package com.ybinsure.auth.model.data;

import java.io.Serializable;
import lombok.Data;

@Data
public class ChannelPermissionDO implements Serializable {
    private String id;

    private String channelCode;

    private String permissionId;

    private Long createTime;

    private static final long serialVersionUID = 1L;
}