package com.ybinsure.auth.serviceImpl.tree;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.tree.PermissionTreeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class DefaultPermissionTreeService implements PermissionTreeService {

    @Override
    public boolean isRoot(PermissionDO permissionDO) {
        return StringUtils.isBlank(permissionDO.getParentId());
    }

    @Override
    public String getKey(PermissionDO permissionDO) {
        return permissionDO.getId();
    }

    @Override
    public String getParentKey(PermissionDO permissionDO) {
        return permissionDO.getParentId();
    }

    @Override
    public void setChildren(PermissionDO parent, List<PermissionDO> list) {
        parent.setChildren(list);
    }

    @Override
    public List<PermissionDO> getChildren(PermissionDO parent) {
        return parent.getChildren();
    }

    @Override
    public Comparator<PermissionDO> comparator() {
        return Comparator.comparing(PermissionDO::getSort);
    }

    @Override
    public List<TreeNode> convertTreeNode(List<PermissionDO> list) {
        return convertTreeNode(list, PermissionDO::convert);
    }
}
