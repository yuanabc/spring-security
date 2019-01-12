package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.service.tool.TokenService;
import com.ybinsure.auth.util.SnowFlake;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultTokenService implements TokenService {

    private final SnowFlake snowFlake;

    // 数据中心序列
    @Value("${nid.machineId}")
    private long datacenterId;

    // 机器序列
    @Value("${nid.datacenterId}")
    private long machineId;

    @Autowired
    public DefaultTokenService() {
        this.snowFlake = new SnowFlake(datacenterId, machineId);
    }

    @Override
    public String suuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public long nuuid() {
        return snowFlake.nextId();
    }

    @Override
    public int verificationCode() {
        return RandomUtils.nextInt(100000, 999999);
    }

    @Override
    public String defaultPassword() {
        return suuid().substring(0, 8);
    }

}
