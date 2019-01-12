package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.mapper.data.PropertyTypeDOMapper;
import com.ybinsure.auth.model.data.PropertyTypeDO;
import com.ybinsure.auth.model.data.PropertyTypeDOExample;
import com.ybinsure.auth.service.data.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPropertyTypeService implements PropertyTypeService {

    private final PropertyTypeDOMapper propertyTypeDOMapper;

    @Override
    @Cacheable(value = CacheKey.propertyTypeQueryAll)
    public Optional<List<PropertyTypeDO>> queryAll() {
        return Optional.ofNullable(propertyTypeDOMapper.selectByExample(new PropertyTypeDOExample()));
    }

    @Override
    @CacheEvict(value = CacheKey.propertyTypeQueryAll, allEntries = true)
    public Optional<String> insert(PropertyTypeDO propertyTypeDO) {
        if (propertyTypeDO == null) {
            return Optional.empty();
        }
        propertyTypeDO.setCreateTime(System.currentTimeMillis());
        propertyTypeDO.setUpdateTime(System.currentTimeMillis());
        if (propertyTypeDOMapper.insertSelective(propertyTypeDO) > 0) {
            return Optional.of(propertyTypeDO.getId());
        }
        return Optional.empty();
    }

    @Override
    @CacheEvict(value = CacheKey.propertyTypeQueryAll, allEntries = true)
    public boolean update(PropertyTypeDO propertyTypeDO) {
        if (StringUtils.isBlank(propertyTypeDO.getId())) {
            return false;
        }
        propertyTypeDO.setUpdateTime(System.currentTimeMillis());
        return propertyTypeDOMapper.updateByPrimaryKeySelective(propertyTypeDO) > 0;
    }

    @Override
    public boolean exist(String code) {
        if (StringUtils.isBlank(code)) {
            return false;
        }
        PropertyTypeDOExample example = new PropertyTypeDOExample();
        example.or().andCodeEqualTo(code);
        return propertyTypeDOMapper.countByExample(example) > 0;
    }
}
