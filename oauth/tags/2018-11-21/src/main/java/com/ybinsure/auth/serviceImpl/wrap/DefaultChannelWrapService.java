package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.constant.*;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.*;
import com.ybinsure.auth.model.link.ChannelLinkBalance;
import com.ybinsure.auth.model.request.finance.ChannelBalanceDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.ChannelQueryPageParamDTO;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.data.WebConfigService;
import com.ybinsure.auth.service.request.ChannelBalanceRequestService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.service.wrap.ChannelWrapService;
import com.ybinsure.auth.service.wrap.PermissionWrapService;
import com.ybinsure.auth.service.wrap.RoleWrapService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultChannelWrapService implements ChannelWrapService {

    private final ChannelService channelService;
    private final TokenClearService tokenClearService;
    private final CompanyService companyService;
    private final UserService userService;
    private final UserWrapService userWrapService;
    private final ChannelBalanceRequestService channelBalanceRequestService;
    private final RoleWrapService roleWrapService;
    private final PermissionWrapService permissionWrapService;
    private final WebConfigService webConfigService;

    @Override
    public boolean delete(String id) {
        boolean res = channelService.delete(id);
        if (res) {
            tokenClearService.clearByChannelId(id);
        }
        return res;
    }

    @Override
    public boolean disable(String id, boolean isClearToken) {
        boolean res = channelService.disable(id);
        if (res && isClearToken) {
            tokenClearService.clearByChannelId(id);
        }
        return res;
    }


    @Override
    @Transactional
    public boolean update(ChannelDO param) {
        ChannelDO existChannelDo = channelService.query(param.getId()).orElseThrow(() -> new FailResultException("未匹配到渠道"));
        param.setCode(existChannelDo.getCode());
        param.setOutCode(existChannelDo.getOutCode());
        if (!roleWrapService.updateAdminRoleRelatePermission(param.getCode(), param.getPermissionIds())) {
            throw new FailResultException("添加渠道权限失败");
        }
        if (!channelService.update(param)) {
            return false;
        }
        if (!companyService.update(param.getHeadCompany())) {
            throw new FailResultException("更新渠道总部机构失败");
        }
        if (!userService.update(param.getAdmin())) {
            throw new FailResultException("更新渠道管理员失败");
        }
        return true;
    }

    @Override
    public boolean isBill(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return false;
        }
        return webConfigService.queryByCode(WebConfigCode.billChannel, channelCode)
                .map(webConfigDO -> webConfigDO.getFlag().equals(StatusCode.ENABLE))
                .orElse(false);
    }

    @Override
    @Transactional
    public Optional<String> insert(ChannelDO param) {
        if (param == null) {
            throw FailResultException.nonError();
        }
        String channelId = insertChannel(param);
        String headId = insertHead(param);
        insertAdmin(param, headId);
        insertChannelPermission(param);
        return Optional.of(channelId);
    }

    private String insertChannel(ChannelDO param) {
        if (channelService.isExist(ChannelDO.createInstanceWithCode(param.getCode()))) {
            throw FailResultException.nonError("渠道" + param.getCode() + "已经存在,");
        }
        return channelService.insert(param).orElseThrow(() -> new FailResultException("添加渠道失败"));
    }

    private String insertHead(ChannelDO param) {
        CompanyDO headCompany = param.getHeadCompany();
        headCompany.setOldCode("0000000001");
        headCompany.setName(param.getShortName());
        headCompany.setCompanyType(CompanyTypeCode.COMPANY);
        headCompany.setChannelHead(StatusCode.ENABLE);
        headCompany.setLevel(CompanyLevelCode.HEAD);
        headCompany.setChannelCode(param.getCode());
        return companyService.insertHead(headCompany).orElseThrow(() -> new FailResultException("添加渠道总部失败"));
    }

    private void insertAdmin(ChannelDO param, String headId) {
        // 创建admin的归属机构
        UserRelateCompanyDO userRelateCompanyDO = new UserRelateCompanyDO();
        userRelateCompanyDO.setCompanyId(headId);
        userRelateCompanyDO.setLinkType(CompanyLinkTypeCode.BELONG);
        UserDO admin = param.getAdmin();
        List<UserRelateCompanyDO> userRelateCompanyDOS = new ArrayList<>();
        userRelateCompanyDOS.add(userRelateCompanyDO);
        admin.setUserRelateCompanyDOS(userRelateCompanyDOS);
        if (userService.isExistByUserName(param.getUserName())) {
            throw FailResultException.nonError("用户" + param.getUserName() + "已经存在");
        }
        if (StringUtils.isBlank(admin.getPassword())) {
            admin.getMd5PasswordWithPhone().ifPresent(admin::setPassword);
        }
        userWrapService.insertAdmin(admin).orElseThrow(() -> new FailResultException("添加渠道管理员失败"));
    }

    private void insertChannelPermission(ChannelDO param) {
        List<RoleRelatePermissionDO> roleRelatePermissionDOS = Optional.ofNullable(param.getPermissionIds()).orElseGet(ArrayList::new)
                .stream()
                .map(permissionId -> {
                    RoleRelatePermissionDO instance = new RoleRelatePermissionDO();
                    instance.setPermissionId(permissionId);
                    return instance;
                })
                .collect(Collectors.toList());
        RoleDO adminRole = RoleDO.createAdminInstance(param.getCode());
        adminRole.setRoleRelatePermissionDOS(roleRelatePermissionDOS);
        boolean insertResult = roleWrapService.insertAdminRoleLinkRoleRelatePermission(adminRole).isPresent();
        if (!insertResult) {
            throw new FailResultException("添加渠道权限失败");
        }
    }

    @Override
    public Optional<List<ChannelDO>> queryAllOfEffective() {
        List<String> companyIds = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
        Optional<List<CompanyDO>> optionalCompanyDOS = companyService.querys(companyIds);
        Optional<List<ChannelDO>> optionalChannelDOList = channelService.queryAll();
        if (!optionalChannelDOList.isPresent() || !optionalCompanyDOS.isPresent()) {
            return Optional.empty();
        }
        // 悦保总部默认查看所有渠道
        if (optionalCompanyDOS.get().stream().anyMatch(companyDO -> ChannelCode.YUEBAO.equals(companyDO.getChannelCode()))) {
            return optionalChannelDOList;
        }
        // 其余根据机构权限查看
        List<ChannelDO> res = optionalChannelDOList.get().stream()
                .filter(channelDO -> optionalCompanyDOS.get().stream().anyMatch(companyDO -> channelDO.getCode().equals(companyDO.getChannelCode())))
                .collect(Collectors.toList());
        return Optional.of(res);
    }

    @Override
    public Optional<PageResult<List<ChannelLinkBalance>>> queryWithPage(PageParam<ChannelQueryPageParamDTO> pageParam) {
        Optional<PageResult<List<ChannelDO>>> sourceResult = channelService.queryWithPage(pageParam);
        long total = sourceResult.map(PageResult::getCount).orElse(0L);
        return sourceResult.map(PageResult::getModel)
                .map(this::requestHeadCompany)
                .map(this::requestChannelBalance)
                .map(channelLinkBalances -> PageResult.instance(total, channelLinkBalances));

    }

    // 请求渠道余额数据
    private List<ChannelLinkBalance> requestChannelBalance(List<ChannelDO> channelDOS) {
        List<ChannelLinkBalance> result = new ArrayList<>();
        channelDOS = Optional.ofNullable(channelDOS).orElseGet(ArrayList::new);
        List<String> channelCodes = channelDOS.stream()
                .map(ChannelDO::getCode).collect(Collectors.toList());
        List<ChannelBalanceDO> channelBalanceDOS = channelBalanceRequestService.queryByChannelCodes(channelCodes).orElseGet(ArrayList::new);
        channelDOS.forEach(channelDO -> {
            ChannelBalanceDO matchChannelBalance = channelBalanceDOS.stream()
                    .filter(channelBalanceDO -> StringUtils.equals(channelBalanceDO.getChannelCode(), channelDO.getCode()))
                    .findAny()
                    .orElseGet(ChannelBalanceDO::new);
            ChannelLinkBalance instance = new ChannelLinkBalance();
            instance.setChannelBalanceDO(matchChannelBalance);
            instance.setChannelDO(channelDO);
            result.add(instance);
        });
        return result;
    }

    // 请求渠道总部数据
    private List<ChannelDO> requestHeadCompany(List<ChannelDO> channelDOS) {
        channelDOS = Optional.ofNullable(channelDOS).orElseGet(ArrayList::new);
        List<String> channelCodes = channelDOS.stream().map(ChannelDO::getCode).collect(Collectors.toList());
        List<CompanyDO> headCompanies = companyService.queryHeadByChannelCodes(channelCodes).orElseGet(ArrayList::new);
        companyService.setDistrict(headCompanies);
        channelDOS.forEach(channelDO -> {
            headCompanies.stream()
                    .filter(companyDO -> StringUtils.equals(companyDO.getChannelCode(), channelDO.getCode()))
                    .findAny()
                    .ifPresent(channelDO::setHeadCompany);
        });
        return channelDOS;
    }

    @Override
    public Optional<ChannelDO> queryChannelLinkAdminAndLinkHeadCompanyAndLinkPermissionById(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        return channelService.query(id).map(channelDO -> {
            List<String> permissionIds = permissionWrapService.queryByChannelCode(channelDO.getCode()).orElseGet(ArrayList::new)
                    .stream()
                    .map(PermissionDO::getId).collect(Collectors.toList());
            CompanyDO headCompany = companyService.queryHeadByChannelCodes(Collections.singletonList(channelDO.getCode()))
                    .map(companyDOS -> companyDOS.size() > 0 ? companyDOS.get(0) : new CompanyDO()).orElseGet(CompanyDO::new);
            UserDO admin = userService.queryAdmin(channelDO.getCode()).orElseGet(UserDO::new);
            channelDO.setAdmin(admin);
            channelDO.setHeadCompany(headCompany);
            channelDO.setPermissionIds(permissionIds);
            return channelDO;
        });
    }

    @Override
    public Optional<List<String>> queryJobNumberPermission(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        return webConfigService.queryByCode(WebConfigCode.Job_NUMBER_PERMISSION, channelCode)
                .map(WebConfigDO::convertValue);
    }

}
