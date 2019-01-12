package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;

import java.util.List;
import java.util.Optional;

public interface ChannelService {

    Optional<ChannelDO> query(String id);

    Optional<List<ChannelDO>> queryAll();

    /**
     * 查询代理渠道的分销渠道
     */
    Optional<List<ChannelDO>> querySalesChannel(String channelCode);

    Optional<ChannelDO> queryByChannelCode(String channelCode);

    Optional<List<ChannelDO>> queryShouldExpireChannels();

    Optional<String> queryInnerCode(String everyCode);

    Optional<PageResult<List<ChannelDO>>> queryWithPage(PageParam<ChannelDO> pageParam);

    Integer maxOrderCode();

    Optional<String> insert(ChannelDO channelDO);

    boolean update(ChannelDO param);

    boolean delete(String id);

    boolean disable(String id);

    boolean recovery(String id);

    boolean isExist(ChannelDO param);

}
