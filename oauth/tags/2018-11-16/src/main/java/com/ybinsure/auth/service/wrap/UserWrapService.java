package com.ybinsure.auth.service.wrap;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.SalesQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.param.UserQueryPageParamDTO;

import java.util.List;
import java.util.Optional;

public interface UserWrapService {

    Optional<String> insertUserLinkCompanyAndLinkRole(UserDO param);

    Optional<String> insertAdmin(UserDO param);

    Optional<String> insertUser(UserDO param);

    Optional<String> insertSale(UserDO param);

    boolean updateUserLinkCompanyAndLinkRole(UserDO param);

    boolean delete(String id);

    boolean disable(String id);

    void setProvinceName(UserDO param);

    void setParentCompany(UserDO param);

    void setUserRelateCompanyLevel(UserDO param);

    /**
     * 分页查询人员信息
     * 包含人员信息，机构信息，角色信息
     * @param pageParam 分页查询参数
     * @return 查询结果
     */
    Optional<PageResult<List<UserDO>>> queryUserLinkCompanyAndLinkRoleAndChannelNameWithPage(PageParam<UserQueryPageParamDTO> pageParam);

    /**
     * 分页查询业务员信息
     * 包含业务员，机构信息
     * @param pageParam 分页查询参数
     * @return 查询结果
     */
    Optional<PageResult<List<UserDO>>> querySalesLinkCompanyAndChannelNameWithPage(PageParam<SalesQueryPageParamDTO> pageParam);

    /**
     * 查询用户信息
     * 包含有用户信息，关联机构，角色，关联渠道
     * @param id 用户id
     * @return 查询结果
     */
    Optional<UserDO> queryUserLinkCompanyAndLinkRoleAndSalesChannelById(String id);

    /**
     * 查询子团队下的业务员
     * @param parentCompanyId 机构id
     * @return 查询结果
     */
    Optional<List<UserDO>> queryTeamChildrenSalesByCompanyId(String parentCompanyId);

}
