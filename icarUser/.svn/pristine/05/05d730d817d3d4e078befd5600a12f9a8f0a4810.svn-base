package com.ybinsure.icar.user.service.impl;

import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.mapper.extend.IcarChannelExtendMapper;
import com.ybinsure.icar.user.model.data.IcarChannelDO;
import com.ybinsure.icar.user.model.dto.IcarChannelDTO;
import com.ybinsure.icar.user.service.data.IcarChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.Set;

/**
 * 工号查询服务实现
 *
 * @author HANHT
 * @version 2018/7/11 16:24
 */
@Service
public class IcarChannelServiceImpl implements IcarChannelService {

    private final IcarChannelExtendMapper icarChannelExtendMapper;

    @Autowired
    public IcarChannelServiceImpl(IcarChannelExtendMapper icarChannelExtendMapper) {
        this.icarChannelExtendMapper = icarChannelExtendMapper;
    }

    @Override
    public Optional<Set<IcarChannelDO>> queryRenewalChannel(IcarChannelDTO dto) {
        Assert.hasText(dto.getAreaCode(), RespInfo.ABNORMAL_DATA.msg);

        return Optional.ofNullable(icarChannelExtendMapper.selectRenewalChannel(dto));
    }

    @Override
    public Optional<IcarChannelDO> queryPingAnChannel(String userId) {
        Assert.hasText(userId, RespInfo.F530.msg);

        return Optional.ofNullable(icarChannelExtendMapper.selectPingAnChannel(userId));
    }
}
