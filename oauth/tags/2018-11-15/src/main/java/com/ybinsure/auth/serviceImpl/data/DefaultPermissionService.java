package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.auto.PermissionDOMapper;
import com.ybinsure.auth.mapper.custom.CustomPermissionDOMapper;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.PermissionDOExample;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.tree.PermissionTreeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultPermissionService implements PermissionService {

    private final PermissionDOMapper permissionDOMapper;
    private final CustomPermissionDOMapper customPermissionDOMapper;
    private final PermissionTreeService permissionTreeService;

    @Override
    public Optional<List<PermissionDO>> queryByIds(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        PermissionDOExample example = new PermissionDOExample();
        example.or().andIdIn(ids);
        return Optional.ofNullable(permissionDOMapper.selectByExample(example));
    }

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
        return queryByTypes(Collections.singletonList(type)).map(permissionTreeService::convertTreeNode);
    }

    @Override
    public Optional<List<PermissionDO>> queryByRoleId(String roleId) {
        if (StringUtils.isBlank(roleId)) {
            return Optional.empty();
        }
        return Optional.ofNullable(customPermissionDOMapper.queryByRoleId(roleId));
    }

    @Override
    public Optional<List<PermissionDO>> queryByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return Optional.empty();
        }
        return Optional.ofNullable(customPermissionDOMapper.queryByUserId(userId))
                .map(permissionDOS -> permissionDOS.stream()
                        .filter(permissionDO -> !Objects.isNull(permissionDO))
                        .collect(Collectors.toList())
                );
    }

}
