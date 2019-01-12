package com.ybinsure.auth.model.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.request.finance.ChannelBalanceDO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ChannelLinkBalance implements Serializable {

    @JsonProperty("channel")
    private ChannelDO channelDO;

    @JsonProperty("channelBalance")
    private ChannelBalanceDO channelBalanceDO;

}
