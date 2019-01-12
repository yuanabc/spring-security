package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.mapper.data.SalesChannelPermissionDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendSalesChannelPermissionDOMapper;
import com.ybinsure.auth.model.data.SalesChannelPermissionDO;
import com.ybinsure.auth.model.data.SalesChannelPermissionDOExample;
import com.ybinsure.auth.service.data.SalesChannelPermissionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultSalesChannelPermissionService implements SalesChannelPermissionService {

    private final SalesChannelPermissionDOMapper salesChannelPermissionDOMapper;
    private final ExtendSalesChannelPermissionDOMapper extendSalesChannelPermissionDOMapper;

    @Override
    public boolean insertList(List<SalesChannelPermissionDO> param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        return extendSalesChannelPermissionDOMapper.insertList(param) == param.size();
    }

    @Override
    public Optional<String> insert(SalesChannelPermissionDO param) {
        if (StringUtils.isBlank(param.getUserId()) ||
                StringUtils.isBlank(param.getPermissionId()) ||
                StringUtils.isBlank(param.getSaleChannelCode())) {
            return Optional.empty();
        }
        param.setCreateTime(System.currentTimeMillis());
        if (salesChannelPermissionDOMapper.insert(param) < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(param.getId());
    }

    @Override
    public Optional<List<SalesChannelPermissionDO>> queryByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return Optional.empty();
        }
        SalesChannelPermissionDOExample example = new SalesChannelPermissionDOExample();
        example.or().andUserIdEqualTo(userId);
        return Optional.ofNullable(salesChannelPermissionDOMapper.selectByExample(example));
    }

    @Override
    public boolean deleteByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return false;
        }
        SalesChannelPermissionDOExample example = new SalesChannelPermissionDOExample();
        example.or().andUserIdEqualTo(userId);
        salesChannelPermissionDOMapper.deleteByExample(example);
        return salesChannelPermissionDOMapper.countByExample(example) == 0;
    }
}
