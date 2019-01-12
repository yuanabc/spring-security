package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.constant.CompanyLevelCode;
import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.constant.SaleTypeCode;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.*;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.SalesQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.param.UserQueryPageParamDTO;
import com.ybinsure.auth.service.data.*;
import com.ybinsure.auth.service.tool.EmptyPasswordService;
import com.ybinsure.auth.service.tool.RestTemplateRequestService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.SplitUserNameUtils;
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
public class DefaultUserWrapService implements UserWrapService {

    private final UserService userService;
    private final CompanyService companyService;
    private final ChannelService channelService;
    private final UserRelateCompanyService userRelateCompanyService;
    private final UserRelateRoleService userRelateRoleService;
    private final SalesChannelService salesChannelService;
    private final DistrictService districtService;
    private final TokenClearService tokenClearService;
    private final EmptyPasswordService emptyPasswordService;
    private final RestTemplateRequestService restTemplateRequestService;


    @Override
    public Optional<String> insertUserLinkCompanyAndLinkRole(UserDO param) {
        this.setParentCompany(param);
        Optional<String> insertUserResult = userService.insert(param);
        if (!insertUserResult.isPresent()) {
            return Optional.empty();
        }
        boolean companyInsertResult = true;
        boolean roleInsertResult = true;
        if (param.getUserRelateCompanyDOS() != null) {
            setUserRelateCompanyLevel(param);
            param.getUserRelateCompanyDOS().forEach(userRelateCompanyDO -> userRelateCompanyDO.setUserId(insertUserResult.get()));
            companyInsertResult = userRelateCompanyService.insertList(param.getUserRelateCompanyDOS());
        }
        if (param.getUserRelateRoleDOS() != null) {
            param.getUserRelateRoleDOS().forEach(userRelateRoleDO -> userRelateRoleDO.setUserId(insertUserResult.get()));
            roleInsertResult = userRelateRoleService.insertList(param.getUserRelateRoleDOS());
        }
        if (companyInsertResult && roleInsertResult) {
            return insertUserResult;
        } else {
            throw FailResultException.nonError();
        }
    }

    @Override
    @Transactional
    public synchronized Optional<String> insertAdmin(UserDO param) {
        param.setUserType(UserTypeCode.ADMIN);
        if (userService.isExistByUserName(param.getUserName())) {
            throw new FailResultException("用户名已经存在");
        }
        return insertUserLinkCompanyAndLinkRole(param);
    }

    @Override
    @Transactional
    public Optional<String> insertUser(UserDO param) {
        param.setUserType(UserTypeCode.USER);
        return insertUserLinkCompanyAndLinkRole(param);
    }

    @Override
    @Transactional
    public Optional<String> insertSale(UserDO param) {
        param.setUserType(UserTypeCode.SALE);
        if (param.getUserRelateRoleDOS() != null) {
            param.getUserRelateRoleDOS().clear();
        }
        setProvinceName(param);
        String result = insertUserLinkCompanyAndLinkRole(param).orElseThrow(() -> new FailResultException("添加业务员失败"));
        if (param.getSalesChannels() != null && !param.getSalesChannels().isEmpty()) {
            if (!StringUtils.equals(SaleTypeCode.CHANNEL, param.getSalesType())) {
                throw new FailResultException("仅渠道业务员才能关联渠道");
            }
            param.getSalesChannels().forEach(value -> {
                value.setUserId(result);
                value.setCreateTime(System.currentTimeMillis());
            });
            if (!salesChannelService.insertList(param.getSalesChannels())) {
                throw new FailResultException("添加关联渠道失败");
            }
        }
        return Optional.of(result);
    }

    @Override
    @Transactional
    public boolean updateUserLinkCompanyAndLinkRole(UserDO param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        if (param.getUserRelateRoleDOS() != null) {
            param.getUserRelateRoleDOS().forEach(userRelateRoleDO -> userRelateRoleDO.setUserId(param.getId()));
            if (!userRelateRoleService.deleteByUserId(param.getId()) || !userRelateRoleService.insertList(param.getUserRelateRoleDOS())) {
                throw new FailResultException("更新角色信息失败");
            }
        }
        if (param.getUserRelateCompanyDOS() != null && !param.getUserRelateCompanyDOS().isEmpty()) {
            setParentCompany(param);
            setUserRelateCompanyLevel(param);
            param.getUserRelateCompanyDOS().forEach(userRelateCompanyDO -> userRelateCompanyDO.setUserId(param.getId()));
            if (!userRelateCompanyService.deleteByUserId(param.getId()) || !userRelateCompanyService.insertList(param.getUserRelateCompanyDOS())) {
                throw new FailResultException("更新机构信息失败");
            }
        }
        if (!userService.update(param)) {
            return false;
        }
        updateSalesChannels(param);
        return true;
    }

    private void updateSalesChannels(UserDO param) {
        if (param.getSalesChannels() == null || param.getSalesChannels().isEmpty()) {
            return;
        }
        param.getSalesChannels().forEach(value -> {
            value.setUserId(param.getId());
            value.setCreateTime(System.currentTimeMillis());
        });
        if (!this.salesChannelService.deleteByUserId(param.getId()) || !this.salesChannelService.insertList(param.getSalesChannels())) {
            throw new FailResultException("更新关联渠道失败");
        }
    }

    @Override
    public boolean delete(String id) {
        // token缓存机制变更，过度操作
        loginOperate(id);
        boolean res = userService.delete(id);
        if (res) {
            tokenClearService.clearByUserIds(Collections.singletonList(id));
        }
        return res;
    }

    @Override
    public boolean disable(String id) {
        // token缓存机制变更，过度操作
        loginOperate(id);
        boolean res = userService.disable(id);
        if (res) {
            tokenClearService.clearByUserIds(Collections.singletonList(id));
        }
        return res;
    }

    private void loginOperate(String id) {
        UserDO param = userService.query(id).orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(param);
        String joinUserName = SplitUserNameUtils.join(param.getUserName(), param.getChannelCode());
        restTemplateRequestService.tokenWithFrontClient(joinUserName, param.getPassword());
    }

    @Override
    public void setProvinceName(UserDO param) {
        if (param.getUserRelateCompanyDOS().isEmpty()) {
            return;
        }
        String companyId = param.getUserRelateCompanyDOS().get(param.getUserRelateCompanyDOS().size() - 1).getCompanyId();
        Optional<DistrictDO> districtDOOptional = this.districtService.queryByCompanyId(companyId);
        districtDOOptional.ifPresent(districtDO -> param.setNickName(StringUtils.defaultString(param.getNickName(), param.getIdName()) + "-" + districtDO.getName()));
    }

    @Override
    public void setParentCompany(UserDO param) {
        List<UserRelateCompanyDO> relateCompanyDOS = Optional.ofNullable(param.getUserRelateCompanyDOS()).orElseGet(ArrayList::new);
        String belongUserRelateCompanyId = relateCompanyDOS.stream()
                .filter(userRelateCompanyDO -> StringUtils.equals(userRelateCompanyDO.getLinkType(), CompanyLinkTypeCode.BELONG))
                .findAny()
                .map(UserRelateCompanyDO::getCompanyId)
                .orElseThrow(() -> new FailResultException("归属机构不能为空"));
        List<CompanyDO> parentCompanyDOS = companyService.queryAllParentsWithSelf(belongUserRelateCompanyId).orElseGet(ArrayList::new);
        // 设置UserRelateCompany
        List<UserRelateCompanyDO> parentRelateCompany = parentCompanyDOS.stream()
                .filter(company -> !StringUtils.equals(company.getId(), belongUserRelateCompanyId))
                .map(CompanyDO::convertUserRelateCompanyDo)
                .collect(Collectors.toList());
        relateCompanyDOS.addAll(parentRelateCompany);
        param.setUserRelateCompanyDOS(relateCompanyDOS);
        // 设置company字段
        param.setCompanyIds(parentCompanyDOS);
    }

    @Override
    public void setUserRelateCompanyLevel(UserDO param) {
        List<String> companyIds = param.getUserRelateCompanyDOS().stream().map(UserRelateCompanyDO::getCompanyId).collect(Collectors.toList());
        // 设置companyType
        Optional<List<CompanyDO>> optionalCompanyDOList = companyService.querys(companyIds);
        if (optionalCompanyDOList.isPresent()) {
            param.getUserRelateCompanyDOS().forEach(userRelateCompanyDO -> {
                Byte companyLevel = optionalCompanyDOList.get().stream()
                        .filter(companyDO -> companyDO.getId().equals(userRelateCompanyDO.getCompanyId()))
                        .findAny()
                        .map(CompanyDO::getLevel)
                        .orElse(CompanyLevelCode.LAST);
                userRelateCompanyDO.setCompanyLevel(companyLevel);
            });
        } else {
            throw new FailResultException("查询关联机构信息失败 ");
        }
    }

    @Override
    public Optional<PageResult<List<UserDO>>> queryUserLinkCompanyAndLinkRoleAndChannelNameWithPage(PageParam<UserQueryPageParamDTO> pageParam) {
        return userService.queryUserLinkCompanyAndLinkRoleWithPage(pageParam).map(this::setChannelName);
    }

    @Override
    public Optional<PageResult<List<UserDO>>> querySalesLinkCompanyAndChannelNameWithPage(PageParam<SalesQueryPageParamDTO> pageParam) {
        return userService.querySalesLinkCompanyWithPage(pageParam).map(this::setChannelName);
    }

    @Override
    public Optional<UserDO> queryUserLinkCompanyAndLinkRoleAndSalesChannelById(String id) {
        Optional<UserDO> result = userService.queryUserLinkCompanyAndLinkRoleById(id);
        result.ifPresent(userDO -> {
            salesChannelService.queryByUserId(userDO.getId()).ifPresent(userDO::setSalesChannels);
        });
        return result;
    }

    @Override
    public Optional<List<UserDO>> queryTeamChildrenSalesByCompanyId(String parentCompanyId) {
        return companyService.queryTeamChildren(parentCompanyId)
                .map(companyDOS -> companyDOS.stream().map(CompanyDO::getId).collect(Collectors.toList()))
                .flatMap(companyIds -> userService.queryUserByCompanyIdsAndUserTypes(companyIds, Collections.singletonList(UserTypeCode.SALE)));
    }

    // 设置渠道名称
    private PageResult<List<UserDO>> setChannelName(PageResult<List<UserDO>> param) {
        List<ChannelDO> channelDOS = channelService.queryAll().orElseGet(ArrayList::new);
        Optional.ofNullable(param.getModel()).orElseGet(ArrayList::new)
                .forEach(userDO ->
                        channelDOS.stream()
                                .filter(channelDO -> StringUtils.equals(channelDO.getCode(), userDO.getChannelCode()))
                                .findAny()
                                .ifPresent(channelDO -> userDO.setChannelName(channelDO.getShortName())));
        return param;
    }

}
