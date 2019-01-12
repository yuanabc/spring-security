package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.data.UserDO;

import java.util.Optional;

/**
 * 渠道编码登陆
 */
public interface ChannelLoginService {

    Optional<UserDO> getUserDo(String channelCode, String enNo);

}
