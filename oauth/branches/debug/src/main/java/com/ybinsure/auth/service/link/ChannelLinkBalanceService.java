package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.link.ChannelLinkBalance;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;

import java.util.List;
import java.util.Optional;

public interface ChannelLinkBalanceService {

    /**
     * 分页查询渠道以及关联的渠道金额
     */
    Optional<PageResult<List<ChannelLinkBalance>>> queryWithPage(PageParam<ChannelDO> pageParam);
}
