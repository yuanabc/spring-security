package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.service.wrap.ChannelWrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultChannelWrapService implements ChannelWrapService {

    private final ChannelService channelService;
    private final TokenClearService tokenClearService;

    @Override
    public boolean delete(String id) {
        boolean res = channelService.delete(id);
        if (res) {
            tokenClearService.clearByChannelId(id);
        }
        return res;
    }

    @Override
    public boolean disable(String id, boolean isClearToken) {
        boolean res = channelService.disable(id);
        if (res && isClearToken) {
            tokenClearService.clearByChannelId(id);
        }
        return res;
    }
}
