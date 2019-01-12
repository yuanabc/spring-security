package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.data.PolicyAreaDOMapper;
import com.ybinsure.auth.model.data.PolicyAreaDO;
import com.ybinsure.auth.model.data.PolicyAreaDOExample;
import com.ybinsure.auth.service.data.PolicyAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPolicyAreaService implements PolicyAreaService {

    private final PolicyAreaDOMapper policyAreaDOMapper;

    @Cacheable(value = CacheKey.policyAreaQueryAll)
    @Override
    public Optional<List<PolicyAreaDO>> queryAll() {
        PolicyAreaDOExample example = new PolicyAreaDOExample();
        example.or().andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.ofNullable(policyAreaDOMapper.selectByExample(example));
    }
}
