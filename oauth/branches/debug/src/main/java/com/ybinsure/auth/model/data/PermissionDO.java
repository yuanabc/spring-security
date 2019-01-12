package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ybinsure.auth.model.data.base.BasePermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeConvert;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;

@Setter
@Getter
public class PermissionDO extends BasePermissionDO implements Serializable, TreeConvert {

    private String id;

    private String code;

    private String name;

    private String parentId;

    private String description;

    private String type;

    private String sort;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    @JsonIgnore
    public TreeNode convert() {
        TreeNode treeNode = new TreeNode();
        treeNode.setKey(getId());
        treeNode.setTitle(getName());
        treeNode.setChildren(new ArrayList<>());
        return treeNode;
    }

    @Override
    @JsonIgnore
    public boolean isHead() {
        return StringUtils.isBlank(getParentId());
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
}