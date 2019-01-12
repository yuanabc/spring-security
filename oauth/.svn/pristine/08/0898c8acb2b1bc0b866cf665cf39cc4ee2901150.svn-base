package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.model.data.base.BaseCompanyDO;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "机构数据")
@Setter
@Getter
public class CompanyDO extends BaseCompanyDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "id不能为空")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "机构编码，业务主键")
    private String sequence;

    @ApiModelProperty(value = "渠道定义的机构编码")
    private String oldCode;

    @NotBlank(groups = {InsertAction.class}, message = "name不能为空")
    @ApiModelProperty(value = "机构名称")
    private String name;

    @NotBlank(groups = {InsertAction.class}, message = "companyType不能为空")
    @ApiModelProperty(value = "机构分类，1-机构， 2-团队")
    private String companyType;

    @ApiModelProperty(value = "机构所在地区的保监地编码")
    private String areaCode;

    @NotBlank(groups = {InsertAction.class, QueryTeamByProvinceAndCityAndChannelCode.class}, message = "province不能为空")
    @ApiModelProperty(value = "机构所在省份编码")
    private String province;

    @NotBlank(groups = {InsertAction.class, QueryTeamByProvinceAndCityAndChannelCode.class}, message = "city不能为空")
    @ApiModelProperty(value = "机构所在城市编码")
    private String city;

    @ApiModelProperty(value = "机构所在区县编码")
    private String country;

    @NotBlank(groups = {InsertAction.class}, message = "parentId不能为空")
    @ApiModelProperty(value = "父机构id")
    private String parentId;

    @ApiModelProperty(value = "是否显示政策")
    //todo 删除该属性
    private Byte displayStrategy;

    @ApiModelProperty(value = "机构联系电话")
    private String phone;

    @ApiModelProperty(value = "机构地址")
    private String address;

    @ApiModelProperty(value = "机构负责人")
    private String principal;

    @ApiModelProperty(value = "机构邮政编码")
    private String postCode;

    @ApiModelProperty(value = "机构传真")
    private String fax;

    @ApiModelProperty(value = "备注信息")
    private String description;

    @ApiModelProperty(value = "是否是渠道总部机构,0-是，2-不是")
    private Byte channelHead;

    @NotNull(groups = {InsertAction.class}, message = "level不能为空")
    @ApiModelProperty(value = "机构层级，从0开始")
    private Byte level;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @NotBlank(groups = {InsertAction.class, QueryTeamByProvinceAndCityAndChannelCode.class}, message = "channelCode不能为空")
    @ApiModelProperty(value = "机构所在渠道的编码")
    private String channelCode;

    @NotNull(groups = {InsertAction.class}, message = "deleted不能为空")
    @ApiModelProperty(value = "逻辑删除状态，0-是， 1-不是")
    private Byte deleted;

    @NotNull(groups = {InsertAction.class}, message = "status不能为空")
    @ApiModelProperty(value = "禁用状态，0-是， 1-不是")
    private Byte status;

    @ApiModelProperty(value = "机构创建时间")
    private Long createTime;

    @ApiModelProperty(value = "机构更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "父机构的OldCode")
    private String upcomcode;

    @ApiModelProperty(value = "子机构")
    private List<CompanyDO> children;

    @ApiModelProperty(value = "子机构数量")
    private Integer childrenSize = 0;

    private static final long serialVersionUID = 1L;

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

    public UserRelateCompanyDO convertUserRelateCompanyDo() {
        UserRelateCompanyDO instance = new UserRelateCompanyDO();
        instance.setCompanyId(getId());
        instance.setLinkType(CompanyLinkTypeCode.BELONG);
        instance.setCompanyLevel(getLevel());
        return instance;
    }

    public interface QueryTeamByProvinceAndCityAndChannelCode {}
}