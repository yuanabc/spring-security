package com.ybinsure.auth.service.wrap;

import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.transfer.tree.DistrictTreeOption;

import java.util.List;
import java.util.Optional;

public interface DistrictWrapService {

    List<DistrictTreeOption> queryTreeWithProvinceAndCity();

    Optional<List<DistrictDO>> queryProvinceAndCityByCodes(List<String> codes);

}
