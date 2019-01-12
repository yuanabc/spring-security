package com.ybinsure.auth.model.transfer.param;

import com.ybinsure.auth.model.data.UserDO;

import java.util.List;

public class UserLinkedQueryWithPageParam extends UserDO {

    private String roleId;

    private List<String> companyIds;

    private String companyName;

    private String linkType;

    private List<String> userTypes;

    private String orderCase;

    private String salesChannelCode;

    public UserLinkedQueryWithPageParam() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(List<String> companyIds) {
        this.companyIds = companyIds;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public List<String> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<String> userTypes) {
        this.userTypes = userTypes;
    }

    public String getOrderCase() {
        return orderCase;
    }

    public void setOrderCase(String orderCase) {
        this.orderCase = orderCase;
    }

    public String getSalesChannelCode() {
        return salesChannelCode;
    }

    public void setSalesChannelCode(String salesChannelCode) {
        this.salesChannelCode = salesChannelCode;
    }
}
