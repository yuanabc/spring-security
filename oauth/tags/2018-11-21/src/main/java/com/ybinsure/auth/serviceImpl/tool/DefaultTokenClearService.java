package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultTokenClearService implements TokenClearService {

    private final ConsumerTokenServices consumerTokenServices;
    private final ChannelService channelService;
    private final UserService userService;

    @Override
    public void clearByUserIds(List<String> userId) {
        if (userId == null || userId.isEmpty()) {
            return;
        }
        List<String> tokens = userService.queryLastToken(userId).orElseGet(ArrayList::new);
        clearToken(tokens);
    }

    @Override
    public void clearByCompanyId(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return;
        }
        List<String> tokens = userService.queryLastNonExpireTokenByCompanyId(companyId).orElseGet(ArrayList::new);
        clearToken(tokens);
    }

    @Override
    public void clearByChannelId(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        ChannelDO channelDO = channelService.query(id).orElseGet(ChannelDO::new);
        List<String> tokens = userService.queryLastTokenByNonExpire(channelDO.getCode()).orElseGet(ArrayList::new);
        clearToken(tokens);
    }

    @Override
    public void clearToken(List<String> tokens) {
        log.info("开始清除token---{}", JsonUtil.toJson(tokens).orElse(""));
        for (String token : tokens) {
            if (!consumerTokenServices.revokeToken(token)) {
                log.warn("清除token失败---{}", token);
            }
        }
    }
}
