package com.ybinsure.auth.service.data;

import com.ybinsure.auth.interfaces.MaxCodeOperator;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Optional;

public interface CompanyService extends MaxCodeOperator {

    boolean delete(String id);

    boolean disable(String id);

    boolean recovery(String id);

    Optional<String> insert(CompanyDO param);

    boolean update(CompanyDO param);

    Optional<String> insertHead(CompanyDO param);

    boolean isExist(CompanyDO param);

    Optional<CompanyDO> query(String id);

    Optional<CompanyDO> query(String oldCode, String channelCode);

    Optional<List<CompanyDO>> queryByCodes(List<Long> codes);

    Optional<List<CompanyDO>> querys(List<String> param);

    Optional<List<CompanyDO>> queryByChannelCode(String channelCode);

    Optional<List<CompanyDO>> queryAll();

    Optional<List<TreeNode>> queryTree();

    Optional<List<CompanyTreeNode>> queryCompanyTree();

    Optional<List<CompanyDO>> queryByUserName(String userName, String channelCode, String linkType);

    Optional<CompanyDO> queryRoot();

    Optional<List<CompanyDO>> queryChild(String id);

    /**
     * 查询所有父级机构
     */
    Optional<List<CompanyDO>> queryAllParents(String id);

    /**
     * 查询所有父级机构包含自身节点
     */
    Optional<List<CompanyDO>> queryAllParentsWithSelf(String id);

    Optional<List<TreeNode>> queryAllParentsTree(String id, Integer filterType);

    Optional<PageResult<List<CompanyDO>>> queryWithPage(PageParam<CompanyDO> pageParam);

    /**
     * 查询机构id，name
     */
    Optional<List<CompanyDO>> querySimpleInfo(List<String> ids);

    Optional<List<CompanyDO>> queryByProvinceAndCity(CompanyDO param);

    // 工具方法
    void updateCompanyCode();

}
