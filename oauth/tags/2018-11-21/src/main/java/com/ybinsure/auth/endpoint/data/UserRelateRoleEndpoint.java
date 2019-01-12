package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.UserRelateRoleDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.UserRelateRoleService;
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
@Api(tags = "用户关联角色相关服务")
public class UserRelateRoleEndpoint {

    private final UserRelateRoleService userRelateRoleService;

    @GetMapping(ApiPath.USER_RELATE_ROLE_QUERY_BY_USER_ID)
    @ApiOperation(value = "查询用户关联的角色信息")
    public Result<List<UserRelateRoleDO>> queryByUserId(
            @ApiParam(value = "用户id")
            @PathVariable("id") String id
    ) {
        return Result.success(this.userRelateRoleService.queryByUserId(id).orElseGet(ArrayList::new));
    }

}
