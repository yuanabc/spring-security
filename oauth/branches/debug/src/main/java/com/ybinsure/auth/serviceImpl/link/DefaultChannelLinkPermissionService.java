package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.mapper.link.ChannelLinkPermissionMapper;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.service.link.ChannelLinkPermissionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultChannelLinkPermissionService implements ChannelLinkPermissionService {

    private final ChannelLinkPermissionMapper channelLinkPermissionMapper;

    @Override
    public Optional<List<PermissionDO>> queryByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        return Optional.of(channelLinkPermissionMapper.queryByChannelCode(channelCode));
    }

}
