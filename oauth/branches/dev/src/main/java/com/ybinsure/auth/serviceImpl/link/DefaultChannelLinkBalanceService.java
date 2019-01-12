package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.link.ChannelLinkBalance;
import com.ybinsure.auth.model.request.finance.ChannelBalanceDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.link.ChannelLinkBalanceService;
import com.ybinsure.auth.service.request.ChannelBalanceRequestService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultChannelLinkBalanceService implements ChannelLinkBalanceService {

    private final ChannelService channelService;
    private final ChannelBalanceRequestService channelBalanceRequestService;

    @Override
    public Optional<PageResult<List<ChannelLinkBalance>>> queryWithPage(PageParam<ChannelDO> pageParam) {
        List<ChannelLinkBalance> result = new ArrayList<>();
        Optional<PageResult<List<ChannelDO>>> channelDOOptional = channelService.queryWithPage(pageParam);
        if (channelDOOptional.isPresent() && channelDOOptional.get().getModel() != null && !channelDOOptional.get().getModel().isEmpty()) {
            List<String> channelCodes = channelDOOptional.get().getModel().stream().map(ChannelDO::getCode).collect(Collectors.toList());
            List<ChannelBalanceDO> channelBalanceDOS = channelBalanceRequestService.queryByChannelCodes(channelCodes).orElseGet(ArrayList::new);
            channelDOOptional.get().getModel().forEach(channelDO -> {
                ChannelBalanceDO matchChannelBalance = channelBalanceDOS.stream()
                        .filter(channelBalanceDO -> StringUtils.equals(channelBalanceDO.getChannelCode(), channelDO.getCode()))
                        .findAny()
                        .orElseGet(ChannelBalanceDO::new);
                result.add(new ChannelLinkBalance(channelDO, matchChannelBalance));
            });
        }
        return Optional.of(PageResult.instance(channelDOOptional.orElseGet(PageResult::new).getCount(), result));
    }
}
