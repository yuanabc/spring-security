package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.PropertyTypeDO;

import java.util.List;
import java.util.Optional;

public interface PropertyTypeService {

    Optional<List<PropertyTypeDO>> queryAll();

    Optional<String> insert(PropertyTypeDO propertyTypeDO);

    boolean update(PropertyTypeDO propertyTypeDO);

    boolean exist(String code);

}
