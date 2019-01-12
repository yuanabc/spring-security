package com.ybinsure.auth.service.adapter;

import com.ybinsure.auth.model.data.ChannelDO;

import java.util.List;
import java.util.Optional;

/**
 * 扩展ChannelService， 解决循环依赖
 */
public interface ChannelAdapterService {

    /**
     * 根据登陆用户的机构权限获取可查询的机构渠道范围
     */
    Optional<List<ChannelDO>> queryAllOfEffective();
}
