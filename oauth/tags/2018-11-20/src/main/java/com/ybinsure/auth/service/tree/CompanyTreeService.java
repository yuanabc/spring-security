package com.ybinsure.auth.service.tree;

import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.function.Predicate;

public interface CompanyTreeService extends TreeBaseService<CompanyDO> {

    List<TreeNode> convertTreeNode(List<CompanyDO> list);

    List<TreeNode> convertTreeNode(List<CompanyDO> list, Predicate<CompanyDO> predicate);

}
