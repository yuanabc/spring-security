package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.mapper.auto.SalesChannelDOMapper;
import com.ybinsure.auth.mapper.custom.CustomSalesChannelDOMapper;
import com.ybinsure.auth.model.data.SalesChannelDO;
import com.ybinsure.auth.model.data.SalesChannelDOExample;
import com.ybinsure.auth.service.data.SalesChannelService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultSalesChannelService implements SalesChannelService {

    private final SalesChannelDOMapper salesChannelDOMapper;
    private final CustomSalesChannelDOMapper customSalesChannelDOMapper;

    @Override
    public boolean insertList(List<SalesChannelDO> channelDOS) {
        if (channelDOS == null || channelDOS.isEmpty()) {
            return true;
        }
        return customSalesChannelDOMapper.insertList(channelDOS) == channelDOS.size();
    }

    @Override
    public Optional<List<SalesChannelDO>> queryByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return Optional.empty();
        }
        SalesChannelDOExample example = new SalesChannelDOExample();
        example.or().andUserIdEqualTo(userId);
        return Optional.ofNullable(salesChannelDOMapper.selectByExample(example));
    }

    @Override
    public boolean deleteByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return false;
        }
        SalesChannelDOExample example = new SalesChannelDOExample();
        example.or().andUserIdEqualTo(userId);
        salesChannelDOMapper.deleteByExample(example);
        return salesChannelDOMapper.selectByExample(example).isEmpty();
    }
}
