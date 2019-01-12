package com.ybinsure.auth.serviceImpl.task;

import com.ybinsure.auth.bean.property.FlagProperty;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.task.ChannelCheckTask;
import com.ybinsure.auth.service.wrap.ChannelWrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultChannelCheckTask implements ChannelCheckTask {

    private final ChannelService channelService;
    private final ChannelWrapService channelWrapService;
    private final FlagProperty flagProperty;

    @Scheduled(cron = "0 */4 * * * *")
    @Override
    public void check() {
        if (flagProperty.isChannelCheck()) {
            Optional<List<ChannelDO>> optionalChannelDOList = channelService.queryShouldExpireChannels();
            optionalChannelDOList.ifPresent(channelDOS -> {
                // 已经处于删除状态的渠道，更新禁用状态
                channelDOS.stream()
                        .filter(channelDO -> StatusCode.ENABLE.equals(channelDO.getDeleted()))
                        .forEach(channelDO -> channelService.disable(channelDO.getId()));
                // 其余的执行禁用操作
                channelDOS.stream()
                        .filter(channelDO -> StatusCode.DISABLE.equals(channelDO.getDeleted()))
                        .forEach(channelDO -> channelWrapService.disable(channelDO.getId(), true));
            });
        }
    }
}
