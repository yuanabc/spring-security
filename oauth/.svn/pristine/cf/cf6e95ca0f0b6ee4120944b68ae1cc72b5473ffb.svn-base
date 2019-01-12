package com.ybinsure.auth.model.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.data.RoleRelatePermissionDO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RoleExtend extends RoleDO {

    @JsonProperty("permissions")
    private List<PermissionDO> permissionDOS;

    @JsonProperty("roleRelatePermissions")
    @Valid()
    @NotNull(groups = {InsertAction.class}, message = "roleRelatePermissionDOS不能为空")
    private List<RoleRelatePermissionDO> roleRelatePermissionDOS;

    public RoleExtend() {
    }

    public List<PermissionDO> getPermissionDOS() {
        return permissionDOS;
    }

    public void setPermissionDOS(List<PermissionDO> permissionDOS) {
        this.permissionDOS = permissionDOS;
    }

    public List<RoleRelatePermissionDO> getRoleRelatePermissionDOS() {
        return roleRelatePermissionDOS;
    }

    public void setRoleRelatePermissionDOS(List<RoleRelatePermissionDO> roleRelatePermissionDOS) {
        this.roleRelatePermissionDOS = roleRelatePermissionDOS;
    }
}
