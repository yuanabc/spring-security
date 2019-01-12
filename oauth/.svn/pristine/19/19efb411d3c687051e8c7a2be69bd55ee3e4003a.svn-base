package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.service.tool.RedisOperateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class DefaultRedisOperateService implements RedisOperateService {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void rename(String pattern, String sourcePart, String replacePart) {
        Set<String> keys = stringRedisTemplate.keys(pattern);
        Map<String, String> keyMap = new HashMap<>();
        Optional.ofNullable(keys).orElseGet(HashSet::new)
                .stream()
                .map(key -> new String[]{key, key.replaceAll(sourcePart, replacePart)})
                .forEach(array -> keyMap.put(array[0], array[1]));
        Optional.ofNullable(keys).orElseGet(HashSet::new).forEach(key -> stringRedisTemplate.rename(key, keyMap.get(key)));
    }

    @Override
    public Long increment(String key, Long step, Integer time) {
        time = Optional.ofNullable(time).orElse(60);
        Long sequence = stringRedisTemplate.opsForValue().increment(key, step);
        stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        return sequence;
    }
}
