package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.adapter.ChannelAdapterService;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.wrap.ChannelWrapService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChannelEndpoint {

    private final ChannelService channelService;
    private final ChannelWrapService channelWrapService;
    private final ChannelAdapterService channelAdapterService;

    @GetMapping(ApiPath.CHANNEL_QUERY_ALL_OF_EFFECTIVE)
    public Result<List<ChannelDO>> queryAllOfEffective() {
        return Result.success(channelAdapterService.queryAllOfEffective().orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.CHANNEL_QUERY_SALES_CHANNEL)
    public Result<List<ChannelDO>> querySales(@PathVariable("channelCode") String channelCode) {
        return Result.success(channelService.querySalesChannel(channelCode).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.CHANNEL_QUERY_INNER_CODE)
    public Result<String> queryInnerCode(@PathVariable("code") String code) {
         return channelService.queryInnerCode(code).map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.CHANNEL_QUERY)
    public Result<ChannelDO> query(@PathVariable("id") String id) {
        return channelService.query(id).map(Result::success).orElseGet(Result::nonError);
    }

    @DeleteMapping(ApiPath.CHANNEL_DELETE)
    public Result<Boolean> delete(@PathVariable("id") String id) {
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
    public Result<Boolean> disable(@PathVariable("id") String id) {
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
    public Result<Boolean> recovery(@PathVariable("id") String id) {
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
    public Result<Boolean> update(
            @Validated(UpdateAction.class) @RequestBody() ChannelDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (this.channelService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.CHANNEL_EXIST)
    public Result<Boolean> exist(@RequestBody() ChannelDO param) {
        if (this.channelService.isExist(param)) {
            return Result.success(true);
        }
        return Result.success(false);
    }

}
