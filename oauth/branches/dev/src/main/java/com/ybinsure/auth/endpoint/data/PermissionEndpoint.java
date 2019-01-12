package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.link.UserLinkPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PermissionEndpoint {

    private final PermissionService permissionService;
    private final UserLinkPermissionService userLinkPermissionService;

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_TYPE)
    public Result<List<PermissionDO>> queryByType(@PathVariable("type") String type) {
        return Result.success(permissionService.queryByTypes(Collections.singletonList(type)).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_TYPE_WITH_TREE)
    public Result<List<TreeNode>> queryByTree(@PathVariable("type") String type) {
        return Result.success(permissionService.queryByTypeWithTree(type).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_CHANNEL_CODE_WITH_TREE)
    public Result<List<TreeNode>> queryByChannelCodeWithTree(@PathVariable("code") String channelCode) {
        return Result.success(userLinkPermissionService.queryByChannelCodeWithTree(channelCode).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.PERMISSION_QUERY_BY_ROLE_ID)
    public Result<List<PermissionDO>> queryByRoleId(@PathVariable("id") String roleId) {
        return Result.success(permissionService.queryByRoleId(roleId).orElseGet(ArrayList::new));
    }

}
