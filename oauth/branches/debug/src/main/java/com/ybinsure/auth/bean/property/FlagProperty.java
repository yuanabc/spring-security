package com.ybinsure.auth.bean.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("custom.flag")
public class FlagProperty {

    private boolean channelCheck;

    public boolean isChannelCheck() {
        return channelCheck;
    }

    public void setChannelCheck(boolean channelCheck) {
        this.channelCheck = channelCheck;
    }
}
