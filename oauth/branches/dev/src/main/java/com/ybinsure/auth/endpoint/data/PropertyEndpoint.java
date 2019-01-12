package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PropertyDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PropertyEndpoint {

    private final PropertyService propertyService;

    @GetMapping(ApiPath.PROPERTY_QUERY_BY_TYPE)
    public Result<List<PropertyDO>> queryByType(@RequestParam("typeCode") String typeCode) {
        return Result.success(propertyService.queryByType(typeCode).orElseGet(ArrayList::new));
    }

}
