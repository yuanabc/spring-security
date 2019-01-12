package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PolicyAreaDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.PolicyAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "保监地区编码相关服务")
public class PolicyAreaEndpoint {

    private final PolicyAreaService policyAreaService;

    @GetMapping(ApiPath.POLICY_AREA_QUERY_ALL)
    @ApiOperation(value = "查询所有保监地区编码")
    public Result<List<PolicyAreaDO>> queryAll() {
        return Result.success(policyAreaService.queryAll().orElseGet(ArrayList::new));
    }

}
