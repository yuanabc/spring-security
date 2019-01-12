package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.SalesChannelPermissionDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.SalesChannelPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SalesChannelPermissionEndpoint {

    private final SalesChannelPermissionService salesChannelPermissionService;

    @GetMapping(ApiPath.SALES_CHANNEL_PERMISSION_QUERY_BY_USER_ID)
    public Result<List<SalesChannelPermissionDO>> queryById(@PathVariable("id") String id) {
        return Result.success(salesChannelPermissionService.queryByUserId(id).orElseGet(ArrayList::new));
    }

}
