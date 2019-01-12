package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.PropertyDO;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    Optional<List<PropertyDO>> queryByType(String typeCode);

}
