package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseRoleRelatePermissionDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(description = "角色关联权限数据")
@Setter
@Getter
public class RoleRelatePermissionDO extends BaseRoleRelatePermissionDO implements Serializable {

    @ApiModelProperty(value = "主键数据")
    private String id;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @NotNull(groups = {InsertAction.class, UpdateAction.class}, message = "permissionId不能为空")
    @ApiModelProperty(value = "权限id")
    private String permissionId;

    private static final long serialVersionUID = 1L;
}