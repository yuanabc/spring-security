package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.wrap.PermissionWrapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "权限相关服务")
public class PermissionEndpoint {

    private final PermissionService permissionService;
    private final PermissionWrapService permissionWrapService;

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_TYPE)
    @ApiOperation(value = "查询某类权限")
    public Result<List<PermissionDO>> queryByType(
            @ApiParam(value = "权限分类，关联Property数据", required = true)
            @PathVariable("type") String type
    ) {
        return Result.success(permissionService.queryByTypes(Collections.singletonList(type)).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_TYPE_WITH_TREE)
    @ApiOperation(value = "查询某类权限的树型数据")
    public Result<List<TreeNode>> queryByTree(
            @ApiParam(value = "权限分类，关联Property数据", required = true)
            @PathVariable("type") String type
    ) {
        return Result.success(permissionService.queryByTypeWithTree(type).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_CHANNEL_CODE)
    @ApiOperation(value = "查询渠道用户权限")
    public Result<List<PermissionDO>> queryByChannelCode(
            @ApiParam(value = "渠道编码")
            @PathVariable("code") String code
    ) {
        return Result.success(permissionWrapService.queryByChannelCode(code).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_CHANNEL_CODE_WITH_TREE)
    @ApiOperation(value = "查询渠道拥有权限的树型数据")
    public Result<List<TreeNode>> queryByChannelCodeWithTree(
            @ApiParam(value = "渠道编码")
            @PathVariable("code") String channelCode
    ) {
        return Result.success(permissionWrapService.queryByChannelCodeWithTree(channelCode).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_ROLE_ID)
    @ApiOperation(value = "查询角色关联的权限数据")
    public Result<List<PermissionDO>> queryByRoleId(
            @ApiParam(value = "角色id")
            @PathVariable("id") String roleId
    ) {
        return Result.success(permissionService.queryByRoleId(roleId).orElseGet(ArrayList::new));
    }

}
