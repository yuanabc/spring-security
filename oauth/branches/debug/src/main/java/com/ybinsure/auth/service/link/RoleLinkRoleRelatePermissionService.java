package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.link.RoleExtend;

import java.util.Optional;

public interface RoleLinkRoleRelatePermissionService {

    Optional<String> insert(RoleExtend param);

    boolean update(RoleExtend param);

    Optional<RoleExtend> query(String id);
}
