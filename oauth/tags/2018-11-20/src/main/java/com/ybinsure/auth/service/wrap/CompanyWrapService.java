package com.ybinsure.auth.service.wrap;

import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.link.CompanyLinkWebConfig;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CompanyWrapService {

    boolean delete(String id);

    boolean disable(String id);

    Optional<String> insertCompanyLinkWebConfig(CompanyLinkWebConfig param);

    boolean updateCompanyLinkWebConfig(CompanyLinkWebConfig param);

    /**
     * 按照机构的创建时间重置排序值
     */
    void resetCompanySort();

    /**
     * 查询当前登录用户归属机构下的子机构
     * @return 子机构数据
     */
    Optional<List<CompanyDO>> queryChildrenByToken();

    /**
     * 查询所有机构树，然后使用机构id进行过滤
     * @param ids 机构id
     * @return 过滤后的机构树
     */
    Optional<List<TreeNode>> queryAllTreeFilterByIds(List<String> ids);

    /**
     * 查询当前用户的机构权限内的机构节点， 不限制节点数量
     */
    Optional<List<TreeNode>> queryAllWithTreeOfEffective();

    /**
     * 查询当前用户的机构权限内的机构节点
     * 然后使用id过滤节点
     * 最后使用匹配节点的最上层节点
     */
    Optional<List<TreeNode>> queryAllWithTreeFilterByIdAndOther(String id);

    /**
     * 查询当前用户的机构权限内的机构节点， 数据相较完整
     */
    Optional<List<CompanyDO>> queryCompanyTreeOfEffective();

    /**
     * 查询团队性质的子机构
     */
    Optional<List<String>> queryChildWithTeam(String id);

    Optional<List<String>> queryChildrenWithTeam(List<String> ids);

    /**
     * 按照渠道和保监地区编码查找节点
     */
    Optional<List<TreeNode>> queryWithTreeByChannelCode(CompanyDO param);

    /**
     * 查找子机构树
     * @param ids 机构id
     * @param isFilterTeamCompany 是否过滤团队节点
     * @return 查询数据
     */
    Optional<List<TreeNode>> queryChildrenTreeFilterByIds(List<String> ids, boolean isFilterTeamCompany);

    /**
     * 查询子机构节点
     */
    // todo remove
    Optional<List<TreeNode>> queryCompanyTypeChildrenTreeNode(List<String> ids);

    /**
     * 查询子团队节点
     */
    // todo remove
    Optional<List<TreeNode>> queryChildrenTeamTypeTreeNode(List<String> ids);

    /**
     * 查询子团队以及业务员节点
     */
    // todo remove
    Optional<List<TreeNode>> queryTeamTypeChildrenAndSalesTreeNode(List<String> ids);

    /**
     * 查询父机构
     */
    Optional<Map<String, List<CompanyDO>>> queryParent(List<String> ids);
}
