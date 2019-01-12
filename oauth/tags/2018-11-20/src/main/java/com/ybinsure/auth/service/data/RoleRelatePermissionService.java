package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.RoleRelatePermissionDO;

import java.util.List;
import java.util.Optional;

public interface RoleRelatePermissionService {

    Optional<String> insert(RoleRelatePermissionDO param);

    boolean insertList(List<RoleRelatePermissionDO> list);

    boolean deleteByRoleId(String roleId);

    boolean deleteNotMatchPermissions(List<String> roleIds, List<String> permissionIds);

    boolean hasAnyNonePermission(String roleId, List<String> permissionIds);
}
