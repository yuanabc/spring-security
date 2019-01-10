package com.ybinsure.icar.user.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class ProjectConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .failOnUnknownProperties(false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .indentOutput(true)
                .simpleDateFormat("yyyy-MM-dd");
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setUsePrefix(true);
        // 默认过期时间
        redisCacheManager.setDefaultExpiration(60 * 10);

        return redisCacheManager;
    }
}
