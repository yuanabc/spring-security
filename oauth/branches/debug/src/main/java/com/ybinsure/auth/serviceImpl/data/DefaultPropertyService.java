package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.data.PropertyDOMapper;
import com.ybinsure.auth.model.data.PropertyDO;
import com.ybinsure.auth.model.data.PropertyDOExample;
import com.ybinsure.auth.service.data.PropertyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPropertyService implements PropertyService {

    private final PropertyDOMapper propertyDOMapper;

    @Override
    @Cacheable(value = CacheKey.propertyQueryByType, key = "#typeCode")
    public Optional<List<PropertyDO>> queryByType(String typeCode) {
        if (StringUtils.isBlank(typeCode)) {
            return Optional.empty();
        }
        PropertyDOExample example = new PropertyDOExample();
        example.or().andTypeCodeEqualTo(typeCode)
                .andStatusEqualTo(StatusCode.ENABLE);
        example.setOrderByClause("sort asc");
        return Optional.ofNullable(propertyDOMapper.selectByExample(example));
    }
}
