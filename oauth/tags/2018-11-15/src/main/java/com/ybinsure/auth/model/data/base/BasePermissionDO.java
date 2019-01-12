package com.ybinsure.auth.model.data.base;

import com.ybinsure.auth.model.data.PermissionDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@ApiModel(description = "权限扩展数据")
public class BasePermissionDO {

    @ApiModelProperty(value = "子权限")
    private List<PermissionDO> children;
}
