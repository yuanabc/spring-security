package com.ybinsure.auth.bean.config;

import com.ybinsure.auth.bean.security.CustomClientDetailService;
import com.ybinsure.auth.bean.security.CustomWebResponseExceptionTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final CustomClientDetailService customClientDetailService;
    private final AuthenticationManager authenticationManager;
    private final RedisTokenStore redisTokenStore;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenConverter accessTokenConverter;
    private final CustomWebResponseExceptionTranslator customWebResponseExceptionTranslator;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(customClientDetailService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 禁用refresh_token
        endpoints
                .tokenStore(redisTokenStore)
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST, HttpMethod.GET);
        // 修改auth相关的几个端点
        initEndpoint(endpoints);
        // 修改token过期时间
        endpoints.exceptionTranslator(customWebResponseExceptionTranslator);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients()
                .passwordEncoder(passwordEncoder)
                .tokenKeyAccess("isAnonymous()")
                .checkTokenAccess("isAnonymous()"); // isAuthenticated()
    }

    private void initEndpoint(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {
        endpointsConfigurer
                .pathMapping("/oauth/authorize", "/authorize")
                .pathMapping("/oauth/token", "/token")
                .pathMapping("/oauth/confirm_access", "/confirm_access")
                .pathMapping("/oauth/check_token", "/check_token")
                .pathMapping("/oauth/token_key", "/token_key");
    }

}
