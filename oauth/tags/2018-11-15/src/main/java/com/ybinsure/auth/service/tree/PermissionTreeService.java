package com.ybinsure.auth.service.tree;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;

public interface PermissionTreeService extends TreeBaseService<PermissionDO> {

    List<TreeNode> convertTreeNode(List<PermissionDO> list);
}
