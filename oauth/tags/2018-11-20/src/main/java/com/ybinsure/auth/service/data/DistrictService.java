package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.DistrictDO;

import java.util.List;
import java.util.Optional;

public interface DistrictService {

    /**
     * 查询机构的省份信息
     */
    Optional<DistrictDO> queryByCompanyId(String companyId);

    Optional<List<DistrictDO>> queryProvinceAndCity();

}
