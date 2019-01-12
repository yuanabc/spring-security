package com.ybinsure.auth.service.data;

import com.ybinsure.auth.interfaces.MaxCodeOperator;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Optional;

public interface CompanyService extends MaxCodeOperator {

    boolean delete(String id);

    boolean disable(String id);

    boolean recovery(String id);

    Optional<String> insert(CompanyDO param);

    boolean update(CompanyDO param);

    void setPolicyAreaCode(CompanyDO param);

    /**
     * 同层级机构执行排序操作
     * @param id 机构id
     * @param sortType 排序操作
     * @return 操作结果
     */
    boolean sortById(String id, String sortType);

    Optional<String> insertHead(CompanyDO param);

    void setDistrict(List<CompanyDO> companyDOS);

    boolean isExist(CompanyDO param);

    Optional<CompanyDO> query(String id);

    Optional<CompanyDO> query(String oldCode, String channelCode);

    Optional<List<CompanyDO>> queryByCodes(List<Long> codes);

    Optional<List<CompanyDO>> querys(List<String> ids);

    Optional<List<CompanyDO>> queryByChannelCode(String channelCode);

    Optional<List<CompanyDO>> queryHeadByChannelCodes(List<String> channelCodes);

    Optional<List<CompanyDO>> queryAll();

    Optional<List<TreeNode>> queryTree();

    Optional<List<CompanyDO>> queryCompanyTree();

    Optional<List<CompanyDO>> queryByUserName(String userName, String channelCode, String linkType);

    Optional<CompanyDO> queryRoot();

    Optional<List<CompanyDO>> queryChild(String id);

    Optional<List<CompanyDO>> queryTeamChildren(String id);

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

    Optional<List<CompanyDO>> queryTeamCompanyByProvinceAndCityAndChannelCode(CompanyDO param);

    /**
     * 查询同一层级排序的本机构和前一个机构
     * @param id 机构id
     * @return 前一个机构
     */
    Optional<List<CompanyDO>> queryBeforeSortedCompanyById(String id);

    /**
     * 查询同一层级排序的本机构和后一个机构
     * @param id 机构id
     * @return 后一个机构
     */
    Optional<List<CompanyDO>> queryAfterSortedCompanyById(String id);

    /**
     * 查询父机构下排序值最大的子机构
     * @param parentId 父机构
     * @return 排序值最大的子机构
     */
    Optional<CompanyDO> queryLastSortedCompanyByParentId(String parentId);

    // 工具方法
    void updateCompanyCode();

}
