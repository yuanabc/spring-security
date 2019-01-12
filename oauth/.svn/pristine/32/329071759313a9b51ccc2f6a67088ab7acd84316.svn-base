package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseRoleRelatePermissionDO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class RoleRelatePermissionDO extends BaseRoleRelatePermissionDO implements Serializable {

    private String id;

    private String roleId;

    @NotNull(groups = {InsertAction.class, UpdateAction.class}, message = "permissionId不能为空")
    private String permissionId;

    private static final long serialVersionUID = 1L;
}