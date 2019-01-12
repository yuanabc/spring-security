package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.auto.PolicyAreaDOMapper;
import com.ybinsure.auth.model.data.PolicyAreaDO;
import com.ybinsure.auth.model.data.PolicyAreaDOExample;
import com.ybinsure.auth.service.data.PolicyAreaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    @Override
    public Optional<String> queryPolicyArea(String province, String city) {
        List<PolicyAreaDO> policyAreaDOS = queryAll().orElseGet(ArrayList::new);
        Optional<String> cityAreaCode = policyAreaDOS.stream().filter(policyAreaDO -> StringUtils.equals(policyAreaDO.getDistrictCode(), city)).map(PolicyAreaDO::getAreaCode).findAny();
        if (cityAreaCode.isPresent()) {
            return cityAreaCode;
        }
        return policyAreaDOS.stream().filter(policyAreaDO -> StringUtils.equals(policyAreaDO.getDistrictCode(), province)).map(PolicyAreaDO::getAreaCode).findAny();
    }
}
