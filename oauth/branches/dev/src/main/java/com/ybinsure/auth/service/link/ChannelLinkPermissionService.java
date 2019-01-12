package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.data.PermissionDO;

import java.util.List;
import java.util.Optional;

public interface ChannelLinkPermissionService {

    Optional<List<PermissionDO>> queryByChannelCode(String channelCode);
}
