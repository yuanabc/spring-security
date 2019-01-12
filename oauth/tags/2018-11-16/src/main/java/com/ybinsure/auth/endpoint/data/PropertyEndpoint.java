package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PropertyDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "字典相关服务")
public class PropertyEndpoint {

    private final PropertyService propertyService;

    @GetMapping(ApiPath.PROPERTY_QUERY_BY_TYPE)
    @ApiOperation(value = "查询某类字典")
    public Result<List<PropertyDO>> queryByType(
            @ApiParam(value = "字典分类编码", required = true)
            @RequestParam("typeCode") String typeCode
    ) {
        return Result.success(propertyService.queryByType(typeCode).orElseGet(ArrayList::new));
    }

}
