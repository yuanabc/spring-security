package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.OauthApplicationTests;
import com.ybinsure.auth.service.tool.RedisOperateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DefaultRedisOperateServiceTest extends OauthApplicationTests {

    @Autowired
    private RedisOperateService redisOperateService;

    @Test
    public void rename() {
        String pattern = "*auth_to_access:*";
        String sourcePart = "auth_to_access:";
        String replacePart = "auth_to_access_back:";
        redisOperateService.rename(pattern, sourcePart, replacePart);
    }
}