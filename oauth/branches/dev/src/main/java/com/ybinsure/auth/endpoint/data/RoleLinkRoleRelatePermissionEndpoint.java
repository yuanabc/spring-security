package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.link.RoleExtend;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.service.link.RoleLinkRoleRelatePermissionService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RoleLinkRoleRelatePermissionEndpoint {

    private final RoleService roleService;
    private final RoleLinkRoleRelatePermissionService roleLinkRoleRelatePermissionService;

    @PostMapping(ApiPath.ROLE_LINK_ROLE_RELATE_PERMISSION_INSERT)
    public Result<String> insert(
            @Validated(InsertAction.class) @RequestBody() RoleExtend param, BindingResult bindingResult
    ) {
        Optional<String> checkResult = ValidatedResultUtil.checkField(bindingResult);
        if (checkResult.isPresent()) {
            return Result.error(checkResult.get());
        }
        if (roleService.exist(param)) {
            return Result.error("该角色已经存在");
        }
        return roleLinkRoleRelatePermissionService.insert(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.ROLE_LINK_ROLE_RELATE_PERMISSION_UPDATE)
    public Result<Boolean> update(
            @Validated(UpdateAction.class) @RequestBody() RoleExtend param, BindingResult bindingResult
    ) {
        Optional<String> checkResult = ValidatedResultUtil.checkField(bindingResult);
        if (checkResult.isPresent()) {
            return Result.error(checkResult.get());
        }
        if (roleLinkRoleRelatePermissionService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @GetMapping(ApiPath.ROLE_LINK_ROLE_RELATE_PERMISSION_QUERY)
    public Result<RoleExtend> query(@PathVariable("id") String id) {
        return roleLinkRoleRelatePermissionService.query(id).map(Result::success).orElseGet(Result::nonError);
    }

}
