package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.service.tool.EmptyPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class DefaultEmptyPasswordService implements EmptyPasswordService {

    private final static String DEFAULT_PASSWORD = "87aee03dc1b08b90cb22ee7993a04905";
    private final static String CRYPT_DEFAULT_PASSWORD = "$2a$10$J0VvsYeb4xPh0KfoQ1Cx6u9DsUKQEdcohCcWJcIUdDIsl91dIDIP2";

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Optional<String> getCryptDefaultPassword(String userId) {
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get(CacheKey.defaultEmptyPassword + userId));
    }

    @Override
    public String getDefaultPassword() {
        return DEFAULT_PASSWORD;
    }

    @Override
    public void setDefaultPassword(UserDO param) {
        if (param == null) {
            return;
        }
        param.setPassword(getDefaultPassword());
        storeCryptDefaultPassword(param.getId());
    }

    @Override
    public void storeCryptDefaultPassword(String userId) {
        stringRedisTemplate.opsForValue().set(CacheKey.defaultEmptyPassword + userId, CRYPT_DEFAULT_PASSWORD, 60, TimeUnit.SECONDS);
    }

}
