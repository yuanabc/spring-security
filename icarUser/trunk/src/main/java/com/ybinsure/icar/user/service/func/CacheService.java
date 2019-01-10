package com.ybinsure.icar.user.service.func;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 缓存服务
 *
 * @author HANHT
 * @version 2018/7/3 17:35
 */
public interface CacheService<T> {

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的数据
     */
    void setCacheObject(String key, T value);

    /**
     * 缓存指定时间
     *
     * @param key     缓存的键值
     * @param value   缓存的数据
     * @param timeout 缓存多长时间
     * @param unit    缓存时间单位
     */
    void setCacheObject(String key, T value, long timeout, TimeUnit unit);

    /**
     * 获得缓存的基本对象
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    T getCacheObject(String key);

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 缓存的List数据
     */
    void setCacheList(String key, List<T> dataList);

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 缓存的List数据
     * @param timeout  缓存多长时间
     * @param unit     缓存时间单位
     */
    void setCacheList(String key, List<T> dataList, long timeout, TimeUnit unit);

    /**
     * 添加缓存List数据
     *
     * @param key  缓存的键值
     * @param data 往List缓存数据中添加的数据
     */
    void addCacheList(String key, T data);

    /**
     * 获得缓存的List对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    List<T> getCacheList(String key);

    /**
     * 缓存Map
     *
     * @param key     缓存的键值
     * @param dataMap 缓存的Map数据
     */
    void setCacheMap(String key, Map<String, T> dataMap);

    /**
     * 缓存Map
     *
     * @param key     缓存的键值
     * @param dataMap 缓存的Map数据
     * @param timeout 缓存多长时间
     * @param unit    缓存时间单位
     */
    void setCacheMap(String key, Map<String, T> dataMap, long timeout, TimeUnit unit);

    /**
     * 获得缓存的Map
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    Map<String, T> getCacheMap(String key);

    /**
     * 添加缓存Map数据
     *
     * @param superKey 缓存的键值
     * @param key      Map缓存数据的键值
     * @param data     Map缓存数据的键值对应的数据
     */
    void addCacheMap(String superKey, String key, T data);

    /**
     * 查询缓存Map数据
     *
     * @param superKey 缓存的键值
     * @param key      Map缓存数据的键值
     */
    T getCacheMap(String superKey, String key);

    /**
     * key是否存在
     *
     * @param key 缓存的键值
     */
    boolean exists(String key);

    /**
     * 设置过期时间
     *
     * @param key     缓存的键值
     * @param timeout 缓存多长时间
     * @param unit    缓存时间单位
     */
    void expire(String key, long timeout, TimeUnit unit);

    /**
     * 删除key对应的数据
     *
     * @param key 缓存的键值
     */
    void removeCache(String key);
}
