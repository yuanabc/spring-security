package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    Optional<List<PermissionDO>> queryByTypes(List<String> types);

    Optional<List<TreeNode>> queryByTypeWithTree(String type);

    Optional<List<PermissionDO>> queryByRoleId(String roleId);

    Optional<List<PermissionDO>> queryByUserId(String userId);

}
