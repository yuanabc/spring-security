package com.ybinsure.icar.user.service.redis;

import com.ybinsure.icar.user.service.func.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存工具类
 *
 * @author HANHT
 * @version 2018/7/11 11:19
 */
@Service("redisCacheService")
public class RedisCacheServiceImpl<T> implements CacheService<T> {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);

    @Resource
    private RedisTemplate<String, T> redisTemplate;
    /** Map */
    @Resource
    private HashOperations<String, String, T> hashOperations;
    /** String */
    @Resource
    private ValueOperations<String, T> valueOperations;
    /** List */
    @Resource
    private ListOperations<String, T> listOperations;

    @Override
    public void setCacheObject(String key, T value) {
        // 默认缓存1天
        setCacheObject(key, value, 1, TimeUnit.DAYS);
    }

    @Override
    public void setCacheObject(String key, T value, long timeout, TimeUnit unit) {
        if (value == null) {

            return;
        }

        try {
            // 默认缓存1天
            if (timeout <= 0 || unit == null) {
                timeout = 1;
                unit = TimeUnit.DAYS;
            }

            valueOperations.set(key, value, timeout, unit);
        } catch (Exception e) {
            logger.error("RedisCacheUtil.setCacheObjectWithTimeout exception, key: {}, e: {}", key, e.getMessage());
        }
    }

    @Override
    public T getCacheObject(String key) {
        try {
            return valueOperations.get(key);
        } catch (Exception e) {
            logger.error("RedisCacheUtil getCacheObject exception, key: {}, e: {}", key, e.getMessage());
            return null;
        }
    }

    @Override
    public void setCacheList(String key, List<T> dataList) {
        // 默认缓存1天
        setCacheList(key, dataList, 1, TimeUnit.DAYS);
    }

    @Override
    public void setCacheList(String key, List<T> dataList, long timeout, TimeUnit unit) {
        if (dataList == null || dataList.isEmpty()) {

            return;
        }

        try {
            listOperations.rightPushAll(key, dataList);
            // 默认缓存1天
            expire(key, timeout, unit);
        } catch (Exception e) {
            logger.error("RedisCacheUtil setCacheList exception, key: {}, e: {}", key, e.getMessage());
        }
    }

    @Override
    public void addCacheList(String key, T data) {
        try {
            listOperations.rightPush(key, data);
        } catch (Exception e) {
            logger.error("RedisCacheUtil addCacheList exception, key: {}, e: {}", key, e.getMessage());
        }
    }

    @Override
    public List<T> getCacheList(String key) {
        try {
            return listOperations.range(key, 0, -1);
        } catch (Exception e) {
            logger.error("RedisCacheUtil getCacheList exception, key: {}, e: {}", key, e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void setCacheMap(String key, Map<String, T> dataMap) {
        // 默认缓存1天
        setCacheMap(key, dataMap, 1, TimeUnit.DAYS);
    }

    @Override
    public void setCacheMap(String key, Map<String, T> dataMap, long timeout, TimeUnit unit) {
        if (dataMap == null || dataMap.isEmpty()) {

            return;
        }

        try {
            hashOperations.putAll(key, dataMap);
            // 设置有效期
            expire(key, timeout, unit);
        } catch (Exception e) {
            logger.error("RedisCacheUtil setCacheMap exception, key: {}, e: {}", key, e.getMessage());
        }
    }

    @Override
    public Map<String, T> getCacheMap(String key) {
        try {
            return hashOperations.entries(key);
        } catch (Exception e) {
            logger.error("RedisCacheUtil getCacheMap exception, key: {}, e: {}", key, e.getMessage());
            return Collections.emptyMap();
        }
    }

    @Override
    public void addCacheMap(String superKey, String key, T t) {
        try {
            hashOperations.putIfAbsent(superKey, key, t);
        } catch (Exception e) {
            logger.error("RedisCacheUtil setCacheMap T exception, key: {}, e: {}", key, e.getMessage());
        }
    }

    @Override
    public T getCacheMap(String superKey, String key) {
        try {
            return hashOperations.get(superKey, key);
        } catch (Exception e) {
            logger.error("RedisCacheUtil getCacheMap T exception, key: {}, e: {}", key, e.getMessage());
            return null;
        }
    }

    @Override
    public boolean exists(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error("RedisCacheUtil exists exception, key: {}, e: {}", key, e.getMessage());
            return false;
        }
    }

    @Override
    public void expire(String key, long timeout, TimeUnit unit) {
        // 默认缓存1天
        if (timeout <= 0 || unit == null) {
            timeout = 1;
            unit = TimeUnit.DAYS;
        }

        try {
            redisTemplate.expire(key, timeout, unit);
        } catch (Exception e) {
            logger.error("RedisCacheUtil expire exception, key: {}, e: {}", key, e.getMessage());
        }
    }

    @Override
    public void removeCache(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error("RedisCacheUtil delete exception, key: {}, e: {}", key, e.getMessage());
        }
    }
}
