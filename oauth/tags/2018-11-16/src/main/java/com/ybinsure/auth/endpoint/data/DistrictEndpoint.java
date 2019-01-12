package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.tree.DistrictTreeOption;
import com.ybinsure.auth.service.data.DistrictService;
import com.ybinsure.auth.service.wrap.DistrictWrapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "行政区域相关服务")
public class DistrictEndpoint {

    private final DistrictService districtService;
    private final DistrictWrapService districtWrapService;

    @GetMapping(ApiPath.DISTRICT_QUERY_TREE_WITH_PROVINCE_AND_CITY)
    @ApiOperation(value = "查询省份和城市的级联数据")
    public Result<List<DistrictTreeOption>> queryOptionWithProvinceAndCity() {
        return Result.success(districtWrapService.queryTreeWithProvinceAndCity());
    }

    @GetMapping(ApiPath.DISTRICT_QUERY_WITH_PROVINCE_AND_CITY)
    @ApiOperation(value = "查询省份和城市数据")
    public Result<List<DistrictDO>> queryWithProvinceAndCity() {
        return Result.success(districtService.queryProvinceAndCity().orElseGet(ArrayList::new));
    }

}
