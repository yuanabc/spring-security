package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.tree.TreeConvert;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 树型数据转换服务类
 */
public interface TreeNodeService {

    int DEFAULT_MAX = 200;

    /**
     * 转换树型数据
     * @param sources 元数据
     * @return 树型数据
     */
      List<TreeNode> convert(List<? extends TreeConvert> sources);

      // todo 重构
      List<TreeNode> convertCompany(List<CompanyDO> companyDOS);

    /**
     * 限制树型数据的数量，超出数量则筛选前两层数据
     * @param treeNodes 树型数据
     * @param maxSize 限制数量
     */
    void limitTreeNodeSize(List<TreeNode> treeNodes, long maxSize, List<? extends TreeConvert> treeConverts);

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
     * 判断节点数是否大于指定数量
     */
    boolean greaterSize(List<TreeNode> treeNodes, long maxSize);

    /**
     * 匹配树形数据
     */
    List<TreeNode> matchTreeNodes(List<? extends TreeConvert> matchSources, List<TreeNode> sources);

    /**
     * 匹配节点
     */
    Optional<TreeNode> matchTreeNode(TreeConvert match, List<TreeNode> sources);

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
