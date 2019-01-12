package com.ybinsure.auth.service.tool;

public interface RedisOperateService {

    void rename(String pattern, String sourcePart, String replacePart);

    Long increment(String key, Long step, Integer time);
}
