package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.UserRelateRoleDO;

import java.util.List;
import java.util.Optional;

public interface UserRelateRoleService {

    Optional<String> insert(UserRelateRoleDO param);

    boolean insertList(List<UserRelateRoleDO> params);

    boolean deleteByUserId(String userId);

    boolean deleteByRoleId(String roleId);

    Optional<List<UserRelateRoleDO>> queryByUserId(String userId);
}
