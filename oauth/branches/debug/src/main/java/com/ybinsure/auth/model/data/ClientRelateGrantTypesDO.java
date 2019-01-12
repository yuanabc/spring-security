package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientRelateGrantTypesDO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ClientRelateGrantTypesDO extends BaseClientRelateGrantTypesDO implements Serializable {

    private String id;

    private String clientId;

    private String grantTypeId;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;
}