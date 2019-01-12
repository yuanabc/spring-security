package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientRelateScopeDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(description = "客户端关联操作范围数据")
@Setter
@Getter
public class ClientRelateScopeDO extends BaseClientRelateScopeDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "客户端id")
    private String clientId;

    @ApiModelProperty(value = "操作范围数据id, 关联AuthProperty数据")
    private String scopeId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;
}