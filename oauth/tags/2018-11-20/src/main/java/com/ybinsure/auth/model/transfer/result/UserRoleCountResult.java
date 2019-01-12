package com.ybinsure.auth.model.transfer.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ApiModel(description = "统计每种角色的账号数量")
public class UserRoleCountResult {

    @ApiModelProperty(value = "总计")
    private Integer total;

    @ApiModelProperty(value = "每种角色的数量")
    private List<UserRoleCount> userRoleCounts;

}
