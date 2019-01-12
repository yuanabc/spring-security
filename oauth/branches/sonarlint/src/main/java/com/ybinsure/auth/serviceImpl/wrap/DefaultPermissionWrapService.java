package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.service.tree.PermissionTreeService;
import com.ybinsure.auth.service.wrap.PermissionWrapService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPermissionWrapService implements PermissionWrapService {

    private final PermissionTreeService permissionTreeService;
    private final PermissionService permissionService;
    private final RoleService roleService;

    @Override
    public Optional<List<PermissionDO>> queryByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        return roleService.queryAdminRole(channelCode)
                .flatMap(roleDO -> permissionService.queryByRoleId(roleDO.getId()));
    }

    @Override
    public Optional<List<TreeNode>> queryByChannelCodeWithTree(String channelCode) {
        return queryByChannelCode(channelCode).map(permissionTreeService::convertTreeNode);
    }
}
