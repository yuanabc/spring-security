package com.ybinsure.auth.serviceImpl.link;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.*;
import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.link.UserLinkedMapper;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.UserLinkedQueryWithPageParam;
import com.ybinsure.auth.service.data.*;
import com.ybinsure.auth.service.link.UserExtendService;
import com.ybinsure.auth.service.tool.OrderCodeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultUserExtendService implements UserExtendService {

    private final UserRelateCompanyService userRelateCompanyService;
    private final UserRelateRoleService userRelateRoleService;
    private final UserService userService;
    private final UserLinkedMapper userLinkedMapper;
    private final DistrictService districtService;
    private final CompanyService companyService;
    private final OrderCodeService orderCodeService;
    private final SalesChannelPermissionService salesChannelPermissionService;

    @Override
    public Optional<String> insert(UserExtend param) {
        Optional<String> insertUserResult = userService.insert(param);
        if (!insertUserResult.isPresent()) {
            return Optional.empty();
        }
        this.setParentCompany(param);
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
    public synchronized Optional<String> insertAdmin(UserExtend param) {
        param.setUserType(UserTypeCode.ADMIN);
        Optional<Long> maxCodeOptional = orderCodeService.maxCode(param.getChannelCode(), CodeTypeEnum.ADMIN, userService);
        if (!maxCodeOptional.isPresent()) {
            return Optional.empty();
        }
        param.setCode(maxCodeOptional.get());
        if (userService.isExistByUserName(param.getUserName())) {
            throw new FailResultException("用户名已经存在");
        }
        return insert(param);
    }

    @Override
    @Transactional
    public Optional<String> insertUser(UserExtend param) {
        Optional<Long> maxCodeOptional = orderCodeService.maxCode(param.getChannelCode(), CodeTypeEnum.USER, userService);
        if (!maxCodeOptional.isPresent()) {
            return Optional.empty();
        }
        param.setCode(maxCodeOptional.get());
        param.setUserType(UserTypeCode.USER);
        return insert(param);
    }

    @Override
    @Transactional
    public Optional<String> insertSale(UserExtend param) {
        // 设定业务员类型，暂时清空业务员角色信息
        param.setUserType(UserTypeCode.SALE);
        param.setSalesType(SaleTypeCode.PERSON);
        Optional<Long> maxCodeOptional = orderCodeService.maxCode(param.getChannelCode(), CodeTypeEnum.SALES, userService);
        if (!maxCodeOptional.isPresent()) {
            return Optional.empty();
        }
        param.setCode(maxCodeOptional.get());
        if (param.getUserRelateRoleDOS() != null) {
            param.getUserRelateRoleDOS().clear();
        }
        return insert(param);
    }

    @Override
    public Optional<String> insertChannelSale(UserExtend param) {
        param.setUserType(UserTypeCode.SALE);
        param.setSalesType(SaleTypeCode.CHANNEL);
        Optional<Long> maxCodeOptional = orderCodeService.maxCode(param.getChannelCode(), CodeTypeEnum.SALES, userService);
        if (!maxCodeOptional.isPresent()) {
            return Optional.empty();
        }
        param.setCode(maxCodeOptional.get());
        if (param.getUserRelateRoleDOS() != null) {
            param.getUserRelateRoleDOS().clear();
        }
        setProvinceName(param);
        return insertChannelSalesOperator(param);
    }

    @Transactional
    public Optional<String> insertChannelSalesOperator(UserExtend param) {
        Optional<String> idOptional = insert(param);
        if (!idOptional.isPresent()) {
            throw FailResultException.nonError();
        }
        if (param.getSalesChannelPermissionDOS() != null && !param.getSalesChannelPermissionDOS().isEmpty()) {
            param.getSalesChannelPermissionDOS().forEach(value -> {
                value.setUserId(idOptional.get());
                value.setCreateTime(System.currentTimeMillis());
            });
            if (!salesChannelPermissionService.insertList(param.getSalesChannelPermissionDOS())) {
                throw FailResultException.nonError();
            }
        }
        return idOptional;
    }

    private void setParentCompany(UserExtend param) {
        List<UserRelateCompanyDO> belongCompany = Optional.ofNullable(param.getUserRelateCompanyDOS()).orElseGet(ArrayList::new);
        List<UserRelateCompanyDO> parentCompany = belongCompany
                .stream().filter(userRelateCompanyDO -> StringUtils.equals(userRelateCompanyDO.getLinkType(), CompanyLinkTypeCode.BELONG)).findAny()
                .flatMap(userRelateCompanyDO -> companyService.queryAllParents(userRelateCompanyDO.getCompanyId())).flatMap(this::convertBelongCompany).orElseGet(ArrayList::new);
        belongCompany.addAll(parentCompany);
        param.setUserRelateCompanyDOS(belongCompany);
    }

    private Optional<List<UserRelateCompanyDO>> convertBelongCompany(List<CompanyDO> companyDOS) {
        return Optional.of(
                companyDOS.stream()
                        .map(companyDO -> {
                            UserRelateCompanyDO instance = new UserRelateCompanyDO();
                            instance.setCompanyId(companyDO.getId());
                            instance.setLinkType(CompanyLinkTypeCode.BELONG);
                            return instance;
                        })
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean setRootCompany(UserExtend param) {
        if (StringUtils.isBlank(param.getChannelCode())) {
            return false;
        }
        if (param.getUserRelateCompanyDOS() == null || param.getUserRelateCompanyDOS().isEmpty()) {
            return true;
        }
        Optional<CompanyDO> rootOptional = companyService.queryRoot();
        if (!rootOptional.isPresent()) {
            return false;
        }
        boolean isExist = param.getUserRelateCompanyDOS().stream().anyMatch(item -> rootOptional.get().getId().equals(item.getCompanyId()));
        if (!isExist) {
            UserRelateCompanyDO item = new UserRelateCompanyDO();
            item.setCompanyId(rootOptional.get().getId());
            item.setLinkType(CompanyLinkTypeCode.BELONG);
            param.getUserRelateCompanyDOS().add(item);
        }
        return true;
    }

    private void setProvinceName(UserExtend param) {
        if (param.getUserRelateCompanyDOS().isEmpty()) {
            return;
        }
        String companyId = param.getUserRelateCompanyDOS().get(param.getUserRelateCompanyDOS().size() - 1).getCompanyId();
        Optional<DistrictDO> districtDOOptional = this.districtService.queryByCompanyId(companyId);
        districtDOOptional.ifPresent(districtDO -> param.setNickName(param.getNickName() + "-" + districtDO.getName()));
    }

    @Override
    public Optional<PageResult<List<UserExtend>>> queryUserWithPage(PageParam<UserLinkedQueryWithPageParam> pageParam) {
        if (pageParam.blank()) {
            return Optional.empty();
        }
        UserLinkedQueryWithPageParam model = pageParam.getModel();
        setUserLinkedQueryWithPageParam(model);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<String> ids = userLinkedMapper.queryUserIdWithPage(pageParam.getModel());
        List<UserExtend> result;
        if (!ids.isEmpty()) {
            result = userLinkedMapper.queryUserById(ids, pageParam.getModel().getOrderCase());
        } else {
            result = new ArrayList<>();
        }
        long count = ((Page) ids).getTotal();
        return Optional.of(PageResult.instance(count, result));
    }

    @Override
    public Optional<PageResult<List<UserExtend>>> querySalesWithPage(PageParam<UserLinkedQueryWithPageParam> pageParam) {
        if (pageParam.blank()) {
            return Optional.empty();
        }
        UserLinkedQueryWithPageParam model = pageParam.getModel();
        setUserLinkedQueryWithPageParam(model);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<String> ids = userLinkedMapper.querySalesIdWithPage(pageParam.getModel());
        List<UserExtend> result;
        if (!ids.isEmpty()) {
            result = userLinkedMapper.querySalesById(ids, pageParam.getModel().getOrderCase());
        } else {
            result = new ArrayList<>();
        }
        long count = ((Page) ids).getTotal();
        return Optional.of(PageResult.instance(count, result));
    }

    @Override
    public Optional<PageResult<List<UserExtend>>> queryChannelSalesWithPage(PageParam<UserLinkedQueryWithPageParam> pageParam) {
        if (pageParam.blank()) {
            return Optional.empty();
        }
        UserLinkedQueryWithPageParam model = pageParam.getModel();
        setUserLinkedQueryWithPageParam(model);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<String> ids = userLinkedMapper.queryChannelSalesIdWithPage(pageParam.getModel());
        List<UserExtend> result;
        if (!ids.isEmpty()) {
            result = userLinkedMapper.querySalesById(ids, pageParam.getModel().getOrderCase());
        } else {
            result = new ArrayList<>();
        }
        long count = ((Page) ids).getTotal();
        return Optional.of(PageResult.instance(count, result));
    }

    private void setUserLinkedQueryWithPageParam(UserLinkedQueryWithPageParam param) {
        param.setDeleted(StatusCode.DISABLE);
        if (StringUtils.isNotBlank(param.getUserName())) {
            param.setUserName("%"+ param.getUserName().trim() +"%");
        } else {
            param.setUserName(null);
        }
        if (StringUtils.isNotBlank(param.getPhone())) {
            param.setPhone("%"+ param.getPhone().trim() + "%");
        } else {
            param.setPhone(null);
        }
        if (StringUtils.isNotBlank(param.getNickName())) {
            param.setNickName("%"+ param.getNickName().trim() + "%");
        } else {
            param.setNickName(null);
        }
        if (StringUtils.isNotBlank(param.getIdName())) {
            param.setIdName("%" + param.getIdName().trim() + "%");
        } else {
            param.setIdName(null);
        }
        if (StringUtils.isNotBlank(param.getAgentCode())) {
            param.setAgentCode("%" + param.getAgentCode().trim() + "%");
        } else {
            param.setAgentCode(null);
        }
        if (StringUtils.isNotBlank(param.getCompanyName())) {
            param.setCompanyName("%"+ param.getCompanyName().trim() + "%");
        } else {
            param.setCompanyName(null);
        }
        if (param.getCreateTime() != null && param.getCreateTime() == OrderCode.DESC) {
            param.setOrderCase("u.create_time desc");
        } else {
            param.setOrderCase("u.create_time asc");
        }
    }

    @Override
    public Optional<List<UserExtend>> queryVirtualSales(String channelCode, String salesChannelCode) {
        if (StringUtils.isBlank(channelCode) || StringUtils.isBlank(salesChannelCode)) {
            return Optional.empty();
        }
        return Optional.ofNullable(userLinkedMapper.queryVirtualSales(channelCode, salesChannelCode));
    }

    @Override
    @Transactional
    public boolean update(UserExtend param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        if (!userService.update(param)) {
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
        if (param.getSalesChannelPermissionDOS() != null) {
            param.getSalesChannelPermissionDOS().forEach(value -> {
                value.setUserId(param.getId());
                value.setCreateTime(System.currentTimeMillis());
            });
            if (!this.salesChannelPermissionService.deleteByUserId(param.getId()) || !this.salesChannelPermissionService.insertList(param.getSalesChannelPermissionDOS())) {
                throw FailResultException.nonError();
            }
        }
        return true;
    }

    private void setUserRelateCompanyLevel(UserExtend param) {
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
    public boolean checkUserCompanyStatus(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        return userLinkedMapper.countUserCompanyByNonStatus(id, StatusCode.DISABLE, StatusCode.ENABLE) == 0;
    }

}
