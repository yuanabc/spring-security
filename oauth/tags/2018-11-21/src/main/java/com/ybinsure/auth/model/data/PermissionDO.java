package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ybinsure.auth.model.data.base.BasePermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@ApiModel(description = "权限数据")
@Setter
@Getter
public class PermissionDO extends BasePermissionDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "权限编码")
    private String code;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "上层权限id")
    private String parentId;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "权限分类，1-普通权限，2-分销渠道权限，3-工号权限，4-管理员权限")
    private String type;

    @ApiModelProperty(value = "排序值")
    private String sort;

    @ApiModelProperty(value = "禁用状态，0-可用，1-禁用")
    private Byte status;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    public TreeNode convert() {
        TreeNode treeNode = new TreeNode();
        treeNode.setKey(getId());
        treeNode.setTitle(getName());
        treeNode.setChildren(new ArrayList<>());
        return treeNode;
    }
}