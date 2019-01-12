package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.QueryPageAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.ChannelLinkBalance;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.ChannelQueryPageParamDTO;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.wrap.ChannelWrapService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "渠道相关服务")
public class ChannelEndpoint {

    private final ChannelService channelService;
    private final ChannelWrapService channelWrapService;

    @DeleteMapping(ApiPath.CHANNEL_DELETE)
    @PreAuthorize("hasAuthority(" + PermissionCode.channelDelete + ")")
    @ApiOperation(value = "删除渠道", notes = PermissionCode.tipPrefix + PermissionCode.channelDelete)
    public Result<Boolean> delete(
            @ApiParam(value = "渠道id", required = true) @PathVariable("id") String id
    ) {
        ChannelDO param = new ChannelDO();
        param.setId(id);
        if (!channelService.isExist(param)) {
            return Result.nonError("渠道不存在, ");
        }
        if (channelWrapService.delete(param.getId())) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.CHANNEL_DISABLE)
    @PreAuthorize("hasAuthority(" + PermissionCode.channelDisable + ")")
    @ApiOperation(value = "禁用渠道", notes = PermissionCode.tipPrefix + PermissionCode.channelDisable)
    public Result<Boolean> disable(
            @ApiParam(value = "渠道id", required = true) @PathVariable("id") String id
    ) {
        ChannelDO param = new ChannelDO();
        param.setId(id);
        if (!channelService.isExist(param)) {
            return Result.nonError("渠道不存在, ");
        }
        if (channelWrapService.disable(param.getId(), true)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.CHANNEL_RECOVERY)
    @PreAuthorize("hasAuthority(" + PermissionCode.channelDisable + ")")
    @ApiOperation(value = "恢复渠道", notes = PermissionCode.tipPrefix + PermissionCode.channelDisable)
    public Result<Boolean> recovery(
            @ApiParam(value = "渠道id", required = true) @PathVariable("id") String id
    ) {
        ChannelDO param = new ChannelDO();
        param.setId(id);
        if (!channelService.isExist(param)) {
            return Result.nonError("渠道不存在, ");
        }
        if (channelService.recovery(param.getId())) {
            return Result.success();
        }
        return Result.nonError();
    }


    @PostMapping(ApiPath.CHANNEL_UPDATE)
    @ApiOperation(value = "更新渠道")
    public Result<Boolean> update(
            @ApiParam(value = "请求数据，必要字段: id", required = true)
            @Validated(UpdateAction.class)
            @RequestBody() ChannelDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (this.channelService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.CHANNEL_EXIST)
    @ApiOperation(value = "检查是否存在渠道")
    public Result<Boolean> exist(
            @ApiParam(value = "请求数据，必要字段: id或者code", required = true) @RequestBody() ChannelDO param
    ) {
        if (this.channelService.isExist(param)) {
            return Result.success(true);
        }
        return Result.success(false);
    }

    @GetMapping(ApiPath.CHANNEL_IS_BILL)
    @ApiOperation(value = "检查渠道是否是收费渠道")
    public Result<Boolean> isBill(@PathVariable("channelCode") String channelCode) {
        return Result.success(channelWrapService.isBill(channelCode));
    }

    @PostMapping(ApiPath.CHANNEL_LINKED_INSERT)
    @PreAuthorize("hasAuthority(" + PermissionCode.channelInsert + ")")
    @ApiOperation(value = "添加渠道", notes = PermissionCode.tipPrefix + PermissionCode.channelInsert)
    public Result<String> insert(
            @ApiParam(value = "请求数据, 必要字段: ")
            @Validated({InsertAction.class, UserDO.InsertAdminAction.class})
            @RequestBody() ChannelDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return channelWrapService.insert(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.CHANNEL_LINKED_UPDATE)
    @PreAuthorize("hasAuthority(" + PermissionCode.channelEdit + ")")
    @ApiOperation(value = "更新渠道/渠道管理员信息/角色数据", notes = PermissionCode.tipPrefix + PermissionCode.channelEdit)
    public Result<Boolean> channelLinkedUpdate(
            @ApiParam(value = "更新数据, 必要字段： id", required = true)
            @Validated(UpdateAction.class)
            @RequestBody() ChannelDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (channelWrapService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @GetMapping(ApiPath.CHANNEL_LINKED_QUERY)
    @ApiOperation(value = "查询渠道/渠道管理员信息/角色数据")
    public Result<ChannelDO> channelLinkQuery(
            @ApiParam(value = "渠道id", required = true)
            @PathVariable("id") String id
    ) {
        return channelWrapService.queryChannelLinkAdminAndLinkHeadCompanyAndLinkPermissionById(id)
                .map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.CHANNEL_QUERY_JOB_NUMBER_PERMISSION_CHANNEL_CODE)
    public Result<List<String>> queryJobNumberPermissionByChannelCode(@PathVariable("channelCode") String channelCode) {
        return Result.success(channelWrapService.queryJobNumberPermission(channelCode).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.CHANNEL_LINK_BALANCE_QUERY_BY_PAGE)
    @ApiOperation(value = "分页查询渠道数据，渠道数据包含有余额数据")
    public Result<PageResult<List<ChannelLinkBalance>>> queryWithPage(
            @ApiParam(value = "请求数据，必要参数：page, size", required = true)
            @Validated(QueryPageAction.class)
            @RequestBody() PageParam<ChannelQueryPageParamDTO> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(channelWrapService.queryWithPage(pageParam).orElseGet(PageResult::new));
    }

    @GetMapping(ApiPath.CHANNEL_QUERY_ALL_OF_EFFECTIVE)
    @ApiOperation(value = "查询权限内的所有渠道")
    public Result<List<ChannelDO>> queryAllOfEffective() {
        return Result.success(channelWrapService.queryAllOfEffective().orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.CHANNEL_QUERY_SALES_CHANNEL)
    @ApiOperation(value = "查询代理渠道关联的分销渠道")
    public Result<List<ChannelDO>> querySales(
            @ApiParam(value = "代理渠道编码", required = true)
            @PathVariable("channelCode") String channelCode
    ) {
        return Result.success(channelService.querySalesChannel(channelCode).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.CHANNEL_QUERY_INNER_CODE)
    @ApiOperation(value = "查询渠道内部编码")
    public Result<String> queryInnerCode(
            @ApiParam(value = "渠道对外编码", required = true)
            @PathVariable("code") String code
    ) {
        return channelService.queryInnerCode(code).map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.CHANNEL_QUERY)
    @ApiOperation(value = "查询渠道")
    public Result<ChannelDO> query(
            @ApiParam(value = "渠道id", required = true)
            @PathVariable("id") String id
    ) {
        return channelService.query(id).map(Result::success).orElseGet(Result::nonError);
    }

}
