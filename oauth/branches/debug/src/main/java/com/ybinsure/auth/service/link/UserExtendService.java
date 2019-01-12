package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.UserLinkedQueryWithPageParam;

import java.util.List;
import java.util.Optional;

public interface UserExtendService {

    Optional<String> insert(UserExtend param);

    Optional<String> insertAdmin(UserExtend param);

    Optional<String> insertUser(UserExtend param);

    Optional<String> insertSale(UserExtend param);

    Optional<String> insertChannelSale(UserExtend param);

    boolean setRootCompany(UserExtend param);

    Optional<PageResult<List<UserExtend>>> queryUserWithPage(PageParam<UserLinkedQueryWithPageParam> pageParam);

    Optional<PageResult<List<UserExtend>>> querySalesWithPage(PageParam<UserLinkedQueryWithPageParam> pageParam);

    Optional<PageResult<List<UserExtend>>> queryChannelSalesWithPage(PageParam<UserLinkedQueryWithPageParam> pageParam);

    Optional<List<UserExtend>> queryVirtualSales(String channelCode, String salesChannelCode);

    boolean update(UserExtend param);

    /**
     * 检查用户是否可用
     */
    boolean checkUserCompanyStatus(String id);

}
