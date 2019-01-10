package com.ybinsure.icar.user.constant;

/**
 * 缓存的key
 *
 * @author HANHT
 * @version 2018/6/13 15:49
 */
public interface CacheKey {

    /** LogFilter MDC key */
    String LOG = "log";

    /** 渠道 */
    String USER_SOURCE = "user_source_cache";

    /** 保险公司缓存key */
    String COMPANY = "COMPANY";
}
