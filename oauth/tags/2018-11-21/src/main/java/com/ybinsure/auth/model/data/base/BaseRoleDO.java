package com.ybinsure.auth.model.data.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.RoleRelatePermissionDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(description = "角色扩展数据")
@Setter
@Getter
public class BaseRoleDO {

    @JsonProperty("permissions")
    @ApiModelProperty(value = "权限数据")
    private List<PermissionDO> permissionDOS;

    @JsonProperty("roleRelatePermissions")
    @Valid()
    @NotNull(groups = {InsertAction.class}, message = "roleRelatePermissionDOS不能为空")
    @ApiModelProperty(value = "角色关联权限数据")
    private List<RoleRelatePermissionDO> roleRelatePermissionDOS;

}
