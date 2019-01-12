package com.ybinsure.auth.bean.config;

import com.ybinsure.auth.bean.property.RedisConfigProperty;
import com.ybinsure.auth.constant.CacheKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@Setter
@Getter
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisConfigProperty redisConfigProperty;

    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setUsePrefix(true);
        // 默认过期时间
        redisCacheManager.setDefaultExpiration(60 * 10);
        // 特殊缓存过期时间
        redisCacheManager.setExpires(CacheKey.getSpecialExpires());
        return redisCacheManager;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

    @Bean RedisTemplate<String, Object> objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> objectRedisTemplate = new RedisTemplate<>();
        objectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        objectRedisTemplate.afterPropertiesSet();
        return objectRedisTemplate;
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + redisConfigProperty.getHost() + ":" + redisConfigProperty.getPort())
                .setPassword(redisConfigProperty.getPassword())
                .setDatabase(redisConfigProperty.getDatabase())
                .setConnectionMinimumIdleSize(5)
                .setConnectionPoolSize(10);
        return Redisson.create(config);
    }

}
