package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.ChannelLoginService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultChannelLoginService implements ChannelLoginService {

    private final UserService userService;

    @Override
    public Optional<UserDO> getUserDo(String channelCode, String enNo) {
        if (StringUtils.isNotBlank(channelCode) && StringUtils.isNotBlank(enNo)) {
            return userService.queryByEnNo(enNo, channelCode);
        }
        if (StringUtils.isNotBlank(channelCode)) {
            return userService.queryFist(channelCode);
        }
        return Optional.empty();
    }
}
