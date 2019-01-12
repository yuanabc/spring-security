package com.ybinsure.auth.service.tree;

import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 树型数据转换服务类
 */
public interface TreeNodeService {


    /**
     * 过滤团队机构
     * @param treeNodes
     */
    void filterTeamNodes(List<TreeNode> treeNodes);

    /**
     * 设置叶节点状态
     * @param treeNodes
     */
    void setLeaf(List<TreeNode> treeNodes);

    /**
     * 匹配树形数据
     */
    List<TreeNode> matchTreeNodes(List<String> keys, List<TreeNode> sources);

    /**
     * 匹配节点
     */
    Optional<TreeNode> matchTreeNode(String key, List<TreeNode> sources);

    /**
     * 筛选团队节点
     */
    Optional<List<String>> chooseTeamCompany(TreeNode treeNode);

    /**
     * 按条件查找节点
     */
    Optional<List<TreeNode>> query(List<TreeNode> treeNodes, CompanyDO param);

    Optional<Map<String, List<CompanyDO>>> queryParent(List<String> ids, List<TreeNode> sources);

}
