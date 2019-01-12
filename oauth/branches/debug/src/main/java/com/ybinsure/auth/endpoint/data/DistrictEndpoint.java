package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.tree.DistrictTreeOption;
import com.ybinsure.auth.service.adapter.DistrictAdapterService;
import com.ybinsure.auth.service.data.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DistrictEndpoint {

    private final DistrictService districtService;
    private final DistrictAdapterService districtAdapterService;

    @GetMapping(ApiPath.DISTRICT_QUERY_TREE_WITH_PROVINCE_AND_CITY)
    public Result<List<DistrictTreeOption>> queryOptionWithProvinceAndCity() {
        return Result.success(districtAdapterService.queryTreeWithProvinceAndCity());
    }

    @GetMapping(ApiPath.DISTRICT_QUERY_WITH_PROVINCE_AND_CITY)
    public Result<List<DistrictDO>> queryWithProvinceAndCity() {
        return Result.success(districtService.queryProvinceAndCity().orElseGet(ArrayList::new));
    }

}
