package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.link.ChannelExtend;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.link.ChannelLinkUserService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChannelLinkedEndpoint {

    private final ChannelLinkUserService channelLinkUserService;

    @PostMapping(ApiPath.CHANNEL_LINKED_INSERT)
    public Result<String> insert(
            @Validated({InsertAction.class, UserExtend.InsertAdminAction.class}) @RequestBody() ChannelExtend param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return channelLinkUserService.insert(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.CHANNEL_LINKED_UPDATE)
    public Result<Boolean> update(
            @Validated(UpdateAction.class) @RequestBody() ChannelExtend param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (channelLinkUserService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @GetMapping(ApiPath.CHANNEL_LINKED_QUERY)
    public Result<ChannelExtend> query(@PathVariable("id") String id) {
        return channelLinkUserService.query(id).map(Result::success).orElseGet(Result::nonError);
    }

}
