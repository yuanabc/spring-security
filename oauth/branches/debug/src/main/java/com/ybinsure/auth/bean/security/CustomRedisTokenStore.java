package com.ybinsure.auth.bean.security;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.ClientDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.service.data.ClientService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * 自定义redis token store
 */
@Component
@Slf4j
public class CustomRedisTokenStore extends RedisTokenStore {

    private final ClientService clientService;
    private final UserService userService;

    @Autowired
    public CustomRedisTokenStore(
            RedisConnectionFactory connectionFactory,
            ClientService clientService,
            UserService userService
    ) {
        super(connectionFactory);
        this.clientService = clientService;
        this.userService = userService;
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        refreshToken(token, authentication);
        updateLastLoginInfo(token, authentication);
    }

    // 重新登录刷新过期时间
    private void refreshToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Optional<String> clientId = AuthenticationHelper.customParser(authentication).getClientId();
        if (token instanceof DefaultOAuth2AccessToken && clientId.isPresent()) {
            ClientDO client = clientService.query(clientId.get()).orElseGet(ClientDO::new);
            if (StatusCode.ENABLE.equals(client.getReset())) {
                ((DefaultOAuth2AccessToken) token).setExpiration(new Date(System.currentTimeMillis() + client.getAccessTokenExpiriTime() * 1000L));
            }
        }
        super.storeAccessToken(token, authentication);
    }

    // 更新用户最后登录信息
    private void updateLastLoginInfo(OAuth2AccessToken token, OAuth2Authentication authentication) {
        String userId = AuthenticationHelper.customParser(authentication).getId().orElseThrow(FailResultException::authError);
        UserDO param = new UserDO();
        param.setId(userId);
        param.setLastTokenExpireTime(token.getExpiration());
        param.setLastToken(token.getValue());
        if (!userService.update(param)) {
            log.warn("更新用户登录信息失败---{}", JsonUtil.toJson(param).orElse(""));
        }
    }
}
