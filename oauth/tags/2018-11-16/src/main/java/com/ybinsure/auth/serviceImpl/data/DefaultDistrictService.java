package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.DistrictLevelCode;
import com.ybinsure.auth.mapper.auto.DistrictDOMapper;
import com.ybinsure.auth.mapper.custom.CustomDistrictDOMapper;
import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.data.DistrictDOExample;
import com.ybinsure.auth.service.data.DistrictService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultDistrictService implements DistrictService {

    private final DistrictDOMapper districtDOMapper;
    private final CustomDistrictDOMapper customDistrictDOMapper;

    @Override
    public Optional<DistrictDO> queryByCompanyId(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return Optional.empty();
        }
        return Optional.ofNullable(customDistrictDOMapper.queryByCompanyId(companyId));
    }

    @Override
    @Cacheable(value = CacheKey.districtWithProvinceAndCity)
    public Optional<List<DistrictDO>> queryProvinceAndCity() {
        DistrictDOExample example = new DistrictDOExample();
        example.or().andLevelIn(Arrays.asList(DistrictLevelCode.province, DistrictLevelCode.city));
        return Optional.ofNullable(districtDOMapper.selectByExample(example));
    }

}
