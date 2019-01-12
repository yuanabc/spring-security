package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleEndpoint {

    private final RoleService roleService;

    @DeleteMapping(ApiPath.ROLE_DELETE)
    public Result<Boolean> delete(@PathVariable("id") String id) {
        if (!roleService.exist(id)) {
            return Result.error("该角色不存在，");
        }
        if (roleService.delete(id)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.ROLE_UPDATE)
    public Result<Boolean> update(
            @Validated(UpdateAction.class) @RequestBody() RoleDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (this.roleService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @GetMapping(ApiPath.ROLE_QUERY_BY_CHANNEL_CODE)
    public Result<List<RoleDO>> queryByChannelCode(@RequestParam("code") String code) {
        return Result.success(roleService.queryByChannelCode(code).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.ROLE_QUERY_BY_CHANNEL_CODES)
    public Result<List<RoleDO>> queryByChannelCodes(@RequestBody() List<String> channelCodes) {
        return Result.success(roleService.queryByChannelCodes(channelCodes).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.ROLE_QUERY_WITH_PAGE)
    public Result<PageResult<List<RoleDO>>> queryWithPage(@RequestBody() PageParam<RoleDO> pageParam) {
        return Result.success(roleService.queryWithPage(pageParam).orElseGet(PageResult::new));
    }

    @GetMapping(ApiPath.ROLE_QUERY_TEMPLATE)
    public Result<List<RoleDO>> queryTemplate() {
        return Result.success(roleService.queryTemplateRole().orElseGet(ArrayList::new));
    }

}
