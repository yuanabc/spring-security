package com.ybinsure.auth.endpoint.tool;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.request.AccessTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "服务token相关服务")
@RestController
@RequiredArgsConstructor
public class AccessTokenEndpoint {

    private final AccessTokenService accessTokenService;

    @GetMapping(ApiPath.ACCESS_TOKEN_REFRESH)
    @PreAuthorize("hasAnyAuthority(" + PermissionCode.admin + ")")
    @ApiOperation(value = "手动刷新服务token", notes = PermissionCode.tipPrefix + PermissionCode.admin)
    public Result<Void> accessTokenRefresh() {
        accessTokenService.refreshAccessToken();
        return Result.success();
    }
}
