package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientRelateResourceDO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ClientRelateResourceDO extends BaseClientRelateResourceDO implements Serializable {
    private String id;

    private String clientId;

    private String resourceId;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;
}