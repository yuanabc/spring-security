package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.data.PermissionDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendPermissionDOMapper;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.PermissionDOExample;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.tool.TreeNodeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPermissionService implements PermissionService {

    private final PermissionDOMapper permissionDOMapper;
    private final ExtendPermissionDOMapper extendPermissionDOMapper;
    private final TreeNodeService treeNodeService;

    @Override
    public Optional<List<PermissionDO>> queryByTypes(List<String> types) {
        if (types == null || types.isEmpty()) {
            return Optional.empty();
        }
        PermissionDOExample example = new PermissionDOExample();
        example.or().andTypeIn(types)
                .andStatusEqualTo(StatusCode.ENABLE);
        example.setOrderByClause("sort asc");
        return Optional.of(permissionDOMapper.selectByExample(example));
    }

    @Override
    public Optional<List<TreeNode>> queryByTypeWithTree(String type) {
        return queryByTypes(Collections.singletonList(type)).map(treeNodeService::convert);
    }

    @Override
    public Optional<List<PermissionDO>> queryByRoleId(String roleId) {
        if (StringUtils.isBlank(roleId)) {
            return Optional.empty();
        }
        return Optional.ofNullable(extendPermissionDOMapper.queryByRoleId(roleId));
    }
}
