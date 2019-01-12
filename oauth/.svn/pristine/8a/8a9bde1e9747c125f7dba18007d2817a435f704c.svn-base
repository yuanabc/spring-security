package com.ybinsure.auth.model.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.request.finance.ChannelBalanceDO;

import java.io.Serializable;

public class ChannelLinkBalance implements Serializable {

    @JsonProperty("channel")
    private ChannelDO channelDO;

    @JsonProperty("channelBalance")
    private ChannelBalanceDO channelBalanceDO;

    public ChannelLinkBalance() {
    }

    public ChannelLinkBalance(ChannelDO channelDO) {
        this.channelDO = channelDO;
    }

    public ChannelLinkBalance(ChannelDO channelDO, ChannelBalanceDO channelBalanceDO) {
        this.channelDO = channelDO;
        this.channelBalanceDO = channelBalanceDO;
    }

    public ChannelDO getChannelDO() {
        return channelDO;
    }

    public void setChannelDO(ChannelDO channelDO) {
        this.channelDO = channelDO;
    }

    public ChannelBalanceDO getChannelBalanceDO() {
        return channelBalanceDO;
    }

    public void setChannelBalanceDO(ChannelBalanceDO channelBalanceDO) {
        this.channelBalanceDO = channelBalanceDO;
    }
}
