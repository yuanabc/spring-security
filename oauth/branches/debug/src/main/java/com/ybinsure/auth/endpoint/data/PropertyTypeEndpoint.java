package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PropertyTypeDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PropertyTypeEndpoint {

    private final PropertyTypeService propertyTypeService;

    @GetMapping(ApiPath.PROPERTY_TYPE_QUERY_ALL)
    public Result<List<PropertyTypeDO>> queryAll() {
        return Result.success(propertyTypeService.queryAll().orElseGet(ArrayList::new));
    }


}
