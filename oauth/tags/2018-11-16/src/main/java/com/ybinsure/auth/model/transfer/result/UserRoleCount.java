package com.ybinsure.auth.model.transfer.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "角色的账号数量")
public class UserRoleCount {

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "账号数量")
    private Integer count;

}
