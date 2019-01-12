package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.QueryAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.WebConfigDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.param.ValidList;
import com.ybinsure.auth.service.data.WebConfigService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WebConfigEndpoint {

    private final WebConfigService webConfigService;

    @PostMapping(ApiPath.WEB_CONFIG_INSERT_LIST)
    public Result<Boolean> insertList(
            @Validated(InsertAction.class) @RequestBody()ValidList<WebConfigDO> webConfigDos, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (!webConfigService.deleteAndInsertList(webConfigDos.getWrap())) {
            return Result.nonError();
        }
        return Result.success();
    }

    @GetMapping(ApiPath.WEB_CONFIG_QUERY)
    public Result<List<WebConfigDO>> queryByChannelCode(@PathVariable("value") String value) {
        return Result.success(webConfigService.query(value).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.WEB_CONFIG_QUERY_BY_CODE)
    public Result<WebConfigDO> queryByCode(
            @Validated(QueryAction.class) @RequestBody() WebConfigDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(webConfigService.queryByCode(param).orElseGet(WebConfigDO::new));
    }

}
