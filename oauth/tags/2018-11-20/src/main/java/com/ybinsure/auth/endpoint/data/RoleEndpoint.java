package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.QueryPageAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.service.wrap.RoleWrapService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Api(tags = "角色相关服务")
public class RoleEndpoint {

    private final RoleService roleService;
    private final RoleWrapService roleWrapService;

    @PostMapping(ApiPath.ROLE_LINK_ROLE_RELATE_PERMISSION_INSERT)
    @PreAuthorize("hasAuthority(" + PermissionCode.roleInsert + ")")
    @ApiOperation(value = "添加角色以及角色关联的权限信息", notes = PermissionCode.tipPrefix + PermissionCode.roleInsert)
    public Result<String> insertRoleLinkRoleRelatePermission(
            @ApiParam(value = "请求参数, 必要字段：name，channelCode，template，status，roleRelatePermissionDOS.permissionId", required = true)
            @Validated(InsertAction.class)
            @RequestBody() RoleDO param, BindingResult bindingResult
    ) {
        Optional<String> checkResult = ValidatedResultUtil.checkField(bindingResult);
        if (checkResult.isPresent()) {
            return Result.error(checkResult.get());
        }
        if (roleService.exist(param.getName(), param.getChannelCode())) {
            return Result.error("该角色已经存在");
        }
        return roleWrapService.insertRoleLinkRoleRelatePermission(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.ROLE_LINK_ROLE_RELATE_PERMISSION_UPDATE)
    @PreAuthorize("hasAuthority(" + PermissionCode.roleEdit + ")")
    @ApiOperation(value = "更新角色以及角色关联的权限信息", notes = PermissionCode.tipPrefix + PermissionCode.roleEdit)
    public Result<Boolean> updateRoleLinkRoleRelatePermission(
            @ApiParam(value = "请求参数, 必要字段：id", required = true)
            @Validated(UpdateAction.class)
            @RequestBody() RoleDO param, BindingResult bindingResult
    ) {
        Optional<String> checkResult = ValidatedResultUtil.checkField(bindingResult);
        if (checkResult.isPresent()) {
            return Result.error(checkResult.get());
        }
        RoleDO existRole = roleService.queryById(param.getId()).orElseThrow(() -> new FailResultException("角色不存在"));
        if (StringUtils.equals(existRole.getType(), RoleDO.ROLE_TYPE_ADMIN)) {
            throw new FailResultException("管理员角色不支持手动更新");
        }
        if (roleWrapService.updateRoleLinkRoleRelatePermission(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @DeleteMapping(ApiPath.ROLE_DELETE)
    @PreAuthorize("hasAuthority(" + PermissionCode.roleDelete + ")")
    @ApiOperation(value = "删除角色", notes = PermissionCode.tipPrefix + PermissionCode.roleDelete)
    public Result<Boolean> delete(
            @ApiParam(value = "角色id", required = true)
            @PathVariable("id") String id
    ) {
        if (!roleService.exist(id)) {
            return Result.error("该角色不存在，");
        }
        if (roleService.delete(id)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.ROLE_UPDATE)
    @ApiOperation(value = "更新角色")
    public Result<Boolean> update(
            @ApiParam(value = "请求参数，必要字段：角色Id", required = true)
            @Validated(UpdateAction.class)
            @RequestBody() RoleDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (this.roleService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @GetMapping(ApiPath.ROLE_QUERY_BY_CHANNEL_CODE)
    @ApiOperation(value = "查询渠道下的角色列表")
    public Result<List<RoleDO>> queryByChannelCode(
            @ApiParam(value = "渠道编码", required = true)
            @RequestParam("code") String channelCode
    ) {
        return Result.success(roleService.queryByChannelCode(channelCode).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.ROLE_QUERY_BY_CHANNEL_CODES)
    @ApiOperation(value = "查询多个渠道下的角色列表")
    public Result<List<RoleDO>> queryByChannelCodes(
            @ApiParam(value = "渠道编码", required = true)
            @RequestBody() List<String> channelCodes
    ) {
        return Result.success(roleService.queryByChannelCodes(channelCodes).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.ROLE_QUERY_WITH_PAGE)
    @ApiOperation(value = "分页查询角色数据")
    public Result<PageResult<List<RoleDO>>> queryWithPage(
            @ApiParam(value = "必要字段：page, size, model.channelCode", required = true)
            @Validated(QueryPageAction.class)
            @RequestBody() PageParam<RoleDO> pageParam
    ) {
        return Result.success(roleService.queryWithPage(pageParam).orElseGet(PageResult::new));
    }

    @GetMapping(ApiPath.ROLE_QUERY_TEMPLATE)
    @ApiOperation(value = "查询模板角色")
    public Result<List<RoleDO>> queryTemplate() {
        return Result.success(roleService.queryTemplateRole().orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.ROLE_LINK_ROLE_RELATE_PERMISSION_QUERY)
    @ApiOperation(value = "分页查询角色以及角色关联权限数据")
    public Result<RoleDO> queryRoleLinkRoleRelatePermission(
            @ApiParam(value = "角色id", required = true)
            @PathVariable("id") String id
    ) {
        return roleWrapService.queryRoleLinkRoleRelatePermission(id).map(Result::success).orElseGet(Result::nonError);
    }

}
