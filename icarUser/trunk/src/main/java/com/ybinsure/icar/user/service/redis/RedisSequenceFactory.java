package com.ybinsure.icar.user.service.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * redis计数
 *
 * @author HANHT
 * @version 2018/5/29 12:23
 */
@Service
public class RedisSequenceFactory {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Atomically increments by one the current value.
     */
    public long get(String key) {
        RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return counter.incrementAndGet();
    }

    /**
     * Atomically increments by one the current value.
     */
    public long get(String key, Date expireTime) {
        RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        counter.expireAt(expireTime);

        return counter.incrementAndGet();
    }

    /**
     * Atomically increments by one the current value.
     */
    public long get(String key, long timeout, TimeUnit unit) {
        RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        counter.expire(timeout, unit);

        return counter.incrementAndGet();
    }
}
