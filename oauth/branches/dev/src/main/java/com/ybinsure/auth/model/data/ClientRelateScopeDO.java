package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientRelateScopeDO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ClientRelateScopeDO extends BaseClientRelateScopeDO implements Serializable {
    private String id;

    private String clientId;

    private String scopeId;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;
}