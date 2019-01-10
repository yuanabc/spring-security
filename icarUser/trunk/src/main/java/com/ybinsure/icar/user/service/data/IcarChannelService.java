package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.data.IcarChannelDO;
import com.ybinsure.icar.user.model.dto.IcarChannelDTO;

import java.util.Optional;
import java.util.Set;

/**
 * 工号查询服务
 *
 * @author HANHT
 * @version 2018/7/11 16:22
 */
public interface IcarChannelService {

    /**
     * 续保查询工号查询
     *
     * @param dto 查询条件
     * @return 工号集
     */
    Optional<Set<IcarChannelDO>> queryRenewalChannel(IcarChannelDTO dto);

    /**
     * 随机查询用户渠道平安工号
     *
     * @param userId 用户id
     * @return 工号
     */
    Optional<IcarChannelDO> queryPingAnChannel(String userId);
}
