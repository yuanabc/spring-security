package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.QueryPageAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.link.ChannelLinkBalance;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.link.ChannelLinkBalanceService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChannelLinkBalanceEndpoint {

    private final ChannelLinkBalanceService channelLinkBalanceService;

    @PostMapping(ApiPath.CHANNEL_LINK_BALANCE_QUERY_BY_PAGE)
    public Result<PageResult<List<ChannelLinkBalance>>> queryWithPage(
            @Validated(QueryPageAction.class) @RequestBody() PageParam<ChannelDO> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(channelLinkBalanceService.queryWithPage(pageParam).orElseGet(PageResult::new));
    }

}
