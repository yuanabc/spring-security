package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PropertyTypeDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.PropertyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "字典分类相关服务")
public class PropertyTypeEndpoint {

    private final PropertyTypeService propertyTypeService;

    @GetMapping(ApiPath.PROPERTY_TYPE_QUERY_ALL)
    @ApiOperation(value = "查询所有字典分类数据")
    public Result<List<PropertyTypeDO>> queryAll() {
        return Result.success(propertyTypeService.queryAll().orElseGet(ArrayList::new));
    }


}
