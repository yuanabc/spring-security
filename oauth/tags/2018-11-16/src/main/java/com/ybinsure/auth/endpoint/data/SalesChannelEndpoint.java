package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.SalesChannelDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.SalesChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "渠道业务员关联渠道相关服务")
public class SalesChannelEndpoint {

    private final SalesChannelService salesChannelService;

    @GetMapping(ApiPath.SALES_CHANNEL_QUERY_BY_USER_ID)
    @ApiOperation(value = "查询渠道业务员关联的渠道")
    public Result<List<SalesChannelDO>> queryByUserId(
            @ApiParam(value = "渠道业务员id", required = true)
            @PathVariable("userId") String userId
    ) {
        return Result.success(salesChannelService.queryByUserId(userId).orElseGet(ArrayList::new));
    }

}
