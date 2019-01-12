package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientRelateResourceDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(description = "客户端关联资源数据")
@Setter
@Getter
public class ClientRelateResourceDO extends BaseClientRelateResourceDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "客户端id")
    private String clientId;

    @ApiModelProperty(value = "资源id, 关联AuthProperty数据")
    private String resourceId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;
}