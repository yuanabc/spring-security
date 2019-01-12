package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.SalesChannelDO;

import java.util.List;
import java.util.Optional;

public interface SalesChannelService {

    boolean insertList(List<SalesChannelDO> channelDOS);

    Optional<List<SalesChannelDO>> queryByUserId(String userId);

    boolean deleteByUserId(String userId);
}
