package com.ybinsure.auth.service.wrap;


import com.ybinsure.auth.model.data.RoleDO;

import java.util.List;
import java.util.Optional;

public interface RoleWrapService {

    Optional<String> insertRoleLinkRoleRelatePermission(RoleDO param);

    Optional<String> insertAdminRoleLinkRoleRelatePermission(RoleDO param);

    boolean updateRoleLinkRoleRelatePermission(RoleDO param);

    boolean updateAdminRoleRelatePermission(String channelCode, List<String> permissionIds);

    Optional<RoleDO> queryRoleLinkRoleRelatePermission(String id);
}
