package com.ybinsure.auth.serviceImpl.task;

import com.ybinsure.auth.bean.property.FlagProperty;
import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.task.ChannelCheckTask;
import com.ybinsure.auth.service.tool.RedisOperateService;
import com.ybinsure.auth.service.wrap.ChannelWrapService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultChannelCheckTask implements ChannelCheckTask {

    private final ChannelService channelService;
    private final ChannelWrapService channelWrapService;
    private final FlagProperty flagProperty;
    private final RedisOperateService redisOperateService;

    @Scheduled(cron = "0 */5 * * * *")
    @Override
    public void check() {
        if (!flagProperty.isChannelCheck()) {
            return;
        }
        // 调度时间周期需大于过期时间
        Long increment = redisOperateService.increment(CacheKey.channelCheckTask, 1L, 60 * 3);
        // 已经由其他服务进行了调度任务
        if (increment > 1) {
            return;
        }
        log.info("开始检查渠道状态...");
        channelService.queryShouldExpireChannels().ifPresent(channelDOS -> {
            log.info("查询异常状态的渠道数据: {}", JsonUtil.toJson(channelDOS).orElse(""));
            // 已经处于删除状态的渠道，更新禁用状态
            channelDOS.stream()
                    .filter(channelDO -> StatusCode.ENABLE.equals(channelDO.getDeleted()))
                    .forEach(channelDO -> channelWrapService.disable(channelDO.getId(), false));
            // 其余的执行禁用操作
            channelDOS.stream()
                    .filter(channelDO -> StatusCode.DISABLE.equals(channelDO.getDeleted()))
                    .forEach(channelDO -> channelWrapService.disable(channelDO.getId(), true));
        });
    }
}
