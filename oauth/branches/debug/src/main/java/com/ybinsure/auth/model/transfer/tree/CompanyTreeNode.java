package com.ybinsure.auth.model.transfer.tree;

import com.ybinsure.auth.constant.CompanyLevelCode;

import java.io.Serializable;
import java.util.List;

public class CompanyTreeNode implements Serializable {

    private String id;
    private String name;
    private String companyType;
    private String province;
    private String city;
    private String parentId;
    private Byte level;
    private Integer sort;
    private String channelCode;
    private Byte status;
    private List<CompanyTreeNode> children;

    public CompanyTreeNode() {
    }

    public boolean isRoot() {
        return CompanyLevelCode.ROOT.equals(getLevel());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<CompanyTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<CompanyTreeNode> children) {
        this.children = children;
    }
}
