package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.link.ChannelExtend;

import java.util.Optional;

public interface ChannelLinkUserService {

    Optional<ChannelExtend> query(String id);

    boolean update(ChannelExtend param);

    Optional<String> insert(ChannelExtend param);

}
