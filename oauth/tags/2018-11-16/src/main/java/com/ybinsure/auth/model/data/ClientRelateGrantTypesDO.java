package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientRelateGrantTypesDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(description = "客户端验证方式数据")
@Setter
@Getter
public class ClientRelateGrantTypesDO extends BaseClientRelateGrantTypesDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "客户端id")
    private String clientId;

    @ApiModelProperty(value = "验证方式id, 关联AuthProperty数据")
    private String grantTypeId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;
}