package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseUserRelateRoleDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@ApiModel(description = "用户关联角色")
@Setter
@Getter
public class UserRelateRoleDO extends BaseUserRelateRoleDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @NotBlank(groups = {UserDO.InsertAdminAction.class, UserDO.InsertUserAction.class, UpdateAction.class}, message = "roleId不能为空")
    @ApiModelProperty(value = "角色id")
    private String roleId;

    private static final long serialVersionUID = 1L;

}