package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.QueryAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.model.data.WebConfigDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.param.ValidList;
import com.ybinsure.auth.service.data.WebConfigService;
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
@Api(tags = "客户端配置相关服务")
public class WebConfigEndpoint {

    private final WebConfigService webConfigService;

    @PostMapping(ApiPath.WEB_CONFIG_INSERT_LIST)
    @PreAuthorize("hasAuthority(" + PermissionCode.admin + ")")
    @ApiOperation(value = "批量添加客户端配置", notes = PermissionCode.tipPrefix + PermissionCode.admin)
    public Result<Boolean> insertList(
            @ApiParam(value = "添加数据， 必要字段：code，value", required = true)
            @Validated(InsertAction.class)
            @RequestBody()ValidList<WebConfigDO> webConfigDos, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (!webConfigService.deleteAndInsertList(webConfigDos.getWrap())) {
            return Result.nonError();
        }
        return Result.success();
    }

    @GetMapping(ApiPath.WEB_CONFIG_QUERY)
    @ApiOperation(value = "查询某类配置数据")
    public Result<List<WebConfigDO>> queryByValue(
            @ApiParam(value = "关联标记，比如机构id, 渠道编码")
            @PathVariable("value") String value
    ) {
        return Result.success(webConfigService.queryByValue(value).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.WEB_CONFIG_QUERY_BY_CODE)
    @ApiOperation(value = "查询某类配置指定配置数据")
    public Result<WebConfigDO> queryByCode(
            @ApiParam(value = "查询参数， 必要字段：code，value", required = true)
            @Validated(QueryAction.class)
            @RequestBody() WebConfigDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(webConfigService.queryByCode(param.getCode(), param.getValue()).orElseGet(WebConfigDO::new));
    }

}
