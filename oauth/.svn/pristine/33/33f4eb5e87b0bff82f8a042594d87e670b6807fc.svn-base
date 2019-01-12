package com.ybinsure.auth.service.tool;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 缓存服务
 * Created by eric on 17-11-27
 */
public interface CacheService {

    /**
     * 使用默认过期时间设置pojo数据
     */
    <T> boolean insertWithDefaultTimeout(String key, T value);

    /**
     * 使用指定时间设置pojo数据
     */
    <T> boolean insert(String key, T value, Integer num, TimeUnit unit);

    /**
     * 删除指定key
     */
    boolean remove(String key);

    /**
     * 查询pojo结构数据
     */
    <T> Optional<T> query(String key);

    /**
     * 检查指定key是否已经缓存
     */
    boolean exists(String key);

    /**
     * 查询指定key的过期时间
     */
    long getExpire(String key);

}
