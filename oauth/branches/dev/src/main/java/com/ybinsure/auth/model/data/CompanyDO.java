package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.CompanyLevelCode;
import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.base.BaseCompanyDO;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeConvert;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

@Setter
@Getter
public class CompanyDO extends BaseCompanyDO implements Serializable, TreeConvert {

    @NotBlank(groups = {UpdateAction.class}, message = "id不能为空")
    private String id;

    private Long code;

    private String oldCode;

    @NotBlank(groups = {InsertAction.class}, message = "name不能为空")
    private String name;

    @NotBlank(groups = {InsertAction.class}, message = "companyType不能为空")
    private String companyType;

    private String areaCode;

    @NotBlank(groups = {InsertAction.class}, message = "province不能为空")
    private String province;

    @NotBlank(groups = {InsertAction.class}, message = "city不能为空")
    private String city;

    private String country;

    @NotBlank(groups = {InsertAction.class}, message = "parentId不能为空")
    private String parentId;

    private Byte displayStrategy;

    private String phone;

    private String address;

    private String principal;

    private String postCode;

    private String fax;

    private String description;

    private Byte channelHead;

    @NotNull(groups = {InsertAction.class}, message = "level不能为空")
    private Byte level;

    private Integer sort;

    @NotBlank(groups = {InsertAction.class}, message = "channelCode不能为空")
    private String channelCode;

    @NotNull(groups = {InsertAction.class}, message = "deleted不能为空")
    private Byte deleted;

    @NotNull(groups = {InsertAction.class}, message = "status不能为空")
    private Byte status;

    private Long createTime;

    private Long updateTime;

    private String upcomcode;

    private static final long serialVersionUID = 1L;

    public static CompanyDO createHeadInstance(String code, String name, String channelCode) {
        CompanyDO instance = new CompanyDO();
        instance.setOldCode(code);
        instance.setName(name);
        instance.setCompanyType(CompanyTypeCode.COMPANY);
        instance.setChannelHead(StatusCode.ENABLE);
        instance.setLevel(CompanyLevelCode.HEAD);
        instance.setSort(1);
        instance.setChannelCode(channelCode);
        instance.setCreateTime(System.currentTimeMillis());
        instance.setUpdateTime(System.currentTimeMillis());
        return instance;
    }

    public static CompanyDO createInstance(String id) {
        CompanyDO instance = new CompanyDO();
        instance.setId(id);
        return instance;
    }

    @Override
    @JsonIgnore
    public TreeNode convert() {
        TreeNode treeNode = new TreeNode();
        treeNode.setKey(getId());
        treeNode.setTitle(getName());
        treeNode.setChildren(new ArrayList<>());
        treeNode.setLevel(getLevel());
        treeNode.setAreaCode(getAreaCode());
        treeNode.setCompanyType(getCompanyType());
        treeNode.setChannelCode(getChannelCode());
        return treeNode;
    }

    public CompanyTreeNode convertCompanyTreeNode() {
        CompanyTreeNode companyTreeNode = new CompanyTreeNode();
        companyTreeNode.setId(getId());
        companyTreeNode.setName(getName());
        companyTreeNode.setCompanyType(getCompanyType());
        companyTreeNode.setProvince(getProvince());
        companyTreeNode.setCity(getCity());
        companyTreeNode.setParentId(getParentId());
        companyTreeNode.setLevel(getLevel());
        companyTreeNode.setSort(getSort());
        companyTreeNode.setChannelCode(getChannelCode());
        companyTreeNode.setStatus(getStatus());
        companyTreeNode.setChildren(new ArrayList<>());
        return companyTreeNode;
    }

    @Override
    @JsonIgnore
    public boolean isHead() {
        return CompanyLevelCode.ROOT.equals(getLevel());
    }

    @Override
    @JsonIgnore
    public String getKey() {
        return getId();
    }

    @Override
    @JsonIgnore
    public String getParentKey() {
        return getParentId();
    }

    public interface QueryByProvinceAndCity {}
}