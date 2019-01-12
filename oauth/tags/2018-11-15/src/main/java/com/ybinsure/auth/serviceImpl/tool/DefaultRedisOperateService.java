package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.service.tool.RedisOperateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

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
}
