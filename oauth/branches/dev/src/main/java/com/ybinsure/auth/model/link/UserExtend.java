package com.ybinsure.auth.model.link;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.model.data.*;
import com.ybinsure.auth.util.AuthenticationHelper;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

import javax.validation.constraints.Size;
import java.util.*;

public class UserExtend extends UserDO {

    @JsonProperty("roles")
    private List<RoleDO> roleDOS;

    @JsonProperty("userRelateRoles")
    private List<UserRelateRoleDO> userRelateRoleDOS;

    @JsonProperty("permissions")
    private List<PermissionDO> permissionDOS;

    @JsonProperty("roleRelatePermissions")
    private List<RoleRelatePermissionDO> roleRelatePermissionDOS;

    @JsonProperty("companies")
    private List<CompanyDO> companyDOS;

    @JsonProperty("userRelateCompanys")
    @Size(groups = {InsertUserAction.class, InsertSaleAction.class, InsertChannelSalesAction.class}, min = 1, message = "关联机构不能为空")
    private List<UserRelateCompanyDO> userRelateCompanyDOS;

    @JsonProperty("belongCompanys")
    private List<CompanyDO> belongCompanys;

    @JsonProperty("managerCompanys")
    private List<CompanyDO> managerCompanys;

    @JsonProperty("salesChannelPermissions")
    private List<SalesChannelPermissionDO> salesChannelPermissionDOS;

    @NotBlank(groups = {InsertSalesWithWebAction.class}, message = "captcha不能为空")
    private String captcha;

    private String channelType;


    public UserExtend() {
    }

    public List<CompanyDO> getCompanyDOS() {
        return companyDOS;
    }

    @JsonIgnore
    public User getUserDetails() {
        return new User(getUserName(), getPassword(), getPermission());
    }

    @JsonIgnore
    private List<GrantedAuthority> getPermission() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (PermissionDO item : permissionDOS) {
            authorities.add(new SimpleGrantedAuthority(item.getCode()));
        }
        // 添加人员信息
        authorities.add(new SwitchUserGrantedAuthority(AuthenticationHelper.customInfoRole, getAuthenticationInfo()));
        return authorities;
    }

    @JsonIgnore
    private Authentication getAuthenticationInfo() {
        String lastBelongCompanyId = Optional.ofNullable(getBelongCompanys()).orElseGet(ArrayList::new)
                .stream().min((e1, e2) -> e2.getLevel() - e1.getLevel()).map(CompanyDO::getId).orElse("");
        Map<String, String> principal = new HashMap<>();
        principal.put(AuthenticationHelper.id, getId());
        principal.put(AuthenticationHelper.channelCode, getChannelCode());
        principal.put(AuthenticationHelper.nickName, getNickName());
        principal.put(AuthenticationHelper.idName, getIdName());
        principal.put(AuthenticationHelper.phone, getPhone());
        principal.put(AuthenticationHelper.belongCompanyId, lastBelongCompanyId);
        return new UsernamePasswordAuthenticationToken(principal, null);
    }

    @JsonIgnore
    public Optional<CompanyDO> getTeamCompany() {
        if (getCompanyDOS() == null || getCompanyDOS().isEmpty()) {
            return Optional.empty();
        }
        return getCompanyDOS()
                .stream()
                .filter(companyDO -> StringUtils.equals(companyDO.getCompanyType(), CompanyTypeCode.TEAM))
                .findAny();
    }

    public void setCompanyDOS(List<CompanyDO> companyDOS) {
        this.companyDOS = companyDOS;
    }

    public List<RoleDO> getRoleDOS() {
        return roleDOS;
    }

    public void setRoleDOS(List<RoleDO> roleDOS) {
        this.roleDOS = roleDOS;
    }

    public List<UserRelateRoleDO> getUserRelateRoleDOS() {
        return userRelateRoleDOS;
    }

    public void setUserRelateRoleDOS(List<UserRelateRoleDO> userRelateRoleDOS) {
        this.userRelateRoleDOS = userRelateRoleDOS;
    }

    public List<UserRelateCompanyDO> getUserRelateCompanyDOS() {
        return userRelateCompanyDOS;
    }

    public void setUserRelateCompanyDOS(List<UserRelateCompanyDO> userRelateCompanyDOS) {
        this.userRelateCompanyDOS = userRelateCompanyDOS;
    }

    public List<PermissionDO> getPermissionDOS() {
        return permissionDOS;
    }

    public void setPermissionDOS(List<PermissionDO> permissionDOS) {
        this.permissionDOS = permissionDOS;
    }

    public List<RoleRelatePermissionDO> getRoleRelatePermissionDOS() {
        return roleRelatePermissionDOS;
    }

    public void setRoleRelatePermissionDOS(List<RoleRelatePermissionDO> roleRelatePermissionDOS) {
        this.roleRelatePermissionDOS = roleRelatePermissionDOS;
    }

    public List<CompanyDO> getBelongCompanys() {
        return belongCompanys;
    }

    public void setBelongCompanys(List<CompanyDO> belongCompanys) {
        this.belongCompanys = belongCompanys;
    }

    public List<CompanyDO> getManagerCompanys() {
        return managerCompanys;
    }

    public void setManagerCompanys(List<CompanyDO> managerCompanys) {
        this.managerCompanys = managerCompanys;
    }

    public List<SalesChannelPermissionDO> getSalesChannelPermissionDOS() {
        return salesChannelPermissionDOS;
    }

    public void setSalesChannelPermissionDOS(List<SalesChannelPermissionDO> salesChannelPermissionDOS) {
        this.salesChannelPermissionDOS = salesChannelPermissionDOS;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public interface InsertAdminAction {}
    public interface InsertUserAction {}
    public interface InsertSaleAction {}
    public interface InsertSalesWithWebAction {}
    public interface InsertChannelSalesAction {}
}
