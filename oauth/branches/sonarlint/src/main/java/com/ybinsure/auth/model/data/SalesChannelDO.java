package com.ybinsure.auth.model.data;

import java.io.Serializable;
import lombok.Data;

@Data
public class SalesChannelDO implements Serializable {
    private String id;

    private String userId;

    private String channelCode;

    private Long createTime;

    private static final long serialVersionUID = 1L;
}