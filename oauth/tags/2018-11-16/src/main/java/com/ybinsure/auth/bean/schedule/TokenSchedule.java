package com.ybinsure.auth.bean.schedule;

import com.ybinsure.auth.bean.security.CustomRedisTokenStore;
import com.ybinsure.auth.constant.ProfileType;
import com.ybinsure.auth.model.data.ClientDO;
import com.ybinsure.auth.service.data.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile(ProfileType.NOT_DEVELOPMENT)
@RequiredArgsConstructor
@Slf4j
public class TokenSchedule {

    private final StringRedisTemplate stringRedisTemplate;
    private final ClientService clientService;

    @Scheduled(cron = "30 30 3 * * *")
    public void clearClientIdToAccess() {
        List<ClientDO> clients = clientService.queryAll().orElseGet(ArrayList::new);
        clients.forEach(clientDO -> {
            String key = CustomRedisTokenStore.CLIENT_ID_TO_ACCESS + clientDO.getClient();
            log.info("开始清除缓存数据：" + key);
            stringRedisTemplate.delete(key);
        });
    }

}
