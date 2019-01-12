package com.ybinsure.auth.model.data.base;

import com.ybinsure.auth.model.data.PropertyDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel(description = "客户端扩展数据")
@Setter
@Getter
public class BaseClientDO {

    @ApiModelProperty(value = "客户端关联的验证方式数据")
    private List<PropertyDO> grantTypes;

    @ApiModelProperty(value = "客户端关联的资源数据")
    private List<PropertyDO> resources;

    @ApiModelProperty(value = "客户端关联的操作范围数据")
    private List<PropertyDO> scopes;
}
