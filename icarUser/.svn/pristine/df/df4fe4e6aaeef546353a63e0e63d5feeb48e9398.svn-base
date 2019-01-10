package com.ybinsure.icar.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 用户登录权限认证
 *
 * @author HANHT
 * @version 2018/7/10 10:44
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public SecurityConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 设置资源标记
        resources.tokenStore(new RedisTokenStore(redisConnectionFactory)).resourceId("OAUTH");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                //                .antMatchers("/guest/**").anonymous() // guest下接口不需要鉴权
                // order下接口需要鉴权
                .antMatchers("/auth/**", "/account/**", "/v1/auth/**")
                // 其他的不需要鉴权
                .authenticated().anyRequest().anonymous();
        //                .anyRequest().authenticated(); // 其他的需要鉴权， 配置自由组合
    }
}
