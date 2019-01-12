package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.service.tool.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 默认实现redis缓存服务
 * created by eric 2017-09-21
 */
@Component
@RequiredArgsConstructor
public class DefaultCacheService implements CacheService {

    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.DAYS;
    private static final int DEFAULT_TIME_UNIT_VALUE = 1;
    private static final String PREFIX = "auth_";

    private RedisTemplate redisTemplate;

    @Override
    public <T> boolean insertWithDefaultTimeout(String key, T value) {
        return insert(key, value, DEFAULT_TIME_UNIT_VALUE, DEFAULT_TIME_UNIT);
    }

    @Override
    public <T> boolean insert(String key, T value, Integer num, TimeUnit unit) {
        key = PREFIX + key;
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, num, unit);
        return exists(key);
    }

    @Override
    public boolean remove(String key) {
        key = PREFIX + key;
        redisTemplate.delete(key);
        return !exists(key);
    }

    @Override
    public <T> Optional<T> query(String key) {
        key = PREFIX + key;
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return Optional.ofNullable(operation.get(key));
    }

    @Override
    public boolean exists(String key) {
        key = PREFIX + key;
        return redisTemplate.hasKey(key);
    }

    @Override
    public long getExpire(String key) {
        key = PREFIX + key;
        return redisTemplate.getExpire(key);
    }

}
