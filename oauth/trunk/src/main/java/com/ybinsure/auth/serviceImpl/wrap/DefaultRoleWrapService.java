package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.custom.CustomRoleDOMapper;
import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.data.RoleRelatePermissionDO;
import com.ybinsure.auth.service.data.RoleRelatePermissionService;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.service.wrap.RoleWrapService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultRoleWrapService implements RoleWrapService {

    private final RoleService roleService;
    private final RoleRelatePermissionService roleRelatePermissionService;
    private final CustomRoleDOMapper customRoleDOMapper;

    @Override
    @Transactional
    public Optional<String> insertRoleLinkRoleRelatePermission(RoleDO param) {
        return roleService.insert(param).map(roleId -> {
            insertRoleRelatePermission(param);
            return roleId;
        });
    }

    @Override
    @Transactional
    public Optional<String> insertAdminRoleLinkRoleRelatePermission(RoleDO param) {
        return roleService.insertAdmin(param).map(roleId -> {
            insertRoleRelatePermission(param);
            return roleId;
        });
    }

    @Override
    @Transactional
    public boolean updateRoleLinkRoleRelatePermission(RoleDO param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        if (!roleRelatePermissionService.deleteByRoleId(param.getId())) {
            throw FailResultException.nonError("删除原有关联权限失败, ");
        }
        insertRoleRelatePermission(param);
        if (!roleService.update(param)) {
            throw FailResultException.nonError("更新角色信息失败, ");
        }
        return true;
    }

    @Override
    @Transactional
    public boolean updateAdminRoleRelatePermission(String channelCode, List<String> permissionIds) {
        // 回收渠道角色的权限
        List<String> roleIds = roleService.queryByChannelCode(channelCode).orElseGet(ArrayList::new)
                .stream()
                .filter(roleDO -> !StringUtils.equals(roleDO.getType(), RoleDO.ROLE_TYPE_ADMIN))
                .map(RoleDO::getId).collect(Collectors.toList());
        if (!roleRelatePermissionService.deleteNotMatchPermissions(roleIds, permissionIds)) {
            throw new FailResultException("回收渠道角色权限失败");
        }
        List<RoleRelatePermissionDO> roleRelatePermissionDOS = Optional.ofNullable(permissionIds).orElseGet(ArrayList::new)
                .stream()
                .map(permissionId -> {
                    RoleRelatePermissionDO instance = new RoleRelatePermissionDO();
                    instance.setPermissionId(permissionId);
                    return instance;
                }).collect(Collectors.toList());
        RoleDO adminRole = roleService.queryAdminRole(channelCode).orElseThrow(() -> new FailResultException("查询渠道角色失败"));
        adminRole.setRoleRelatePermissionDOS(roleRelatePermissionDOS);
        return updateRoleLinkRoleRelatePermission(adminRole);
    }

    private void insertRoleRelatePermission(RoleDO param) {
        if (hasAnyNonePermission(param)) {
            throw new FailResultException("添加角色超出所在渠道的权限范围");
        }
        param.getRoleRelatePermissionDOS().forEach(value -> value.setRoleId(param.getId()));
        if (!roleRelatePermissionService.insertList(param.getRoleRelatePermissionDOS())) {
            throw FailResultException.nonError("添加新关联权限失败, ");
        }
    }

    // 检查角色是否超出渠道权限
    private boolean hasAnyNonePermission(RoleDO param) {
        if (!ChannelCode.isAnyAdminChannel(param.getChannelCode()) && !StringUtils.equals(param.getType(), RoleDO.ROLE_TYPE_ADMIN)) {
            List<String> permissionIds = param.getRoleRelatePermissionDOS()
                    .stream()
                    .map(RoleRelatePermissionDO::getPermissionId)
                    .collect(Collectors.toList());
            RoleDO adminRole = roleService.queryAdminRole(param.getChannelCode()).orElseThrow(() -> new FailResultException("为查询到渠道管理员信息"));
            return roleRelatePermissionService.hasAnyNonePermission(adminRole.getId(), permissionIds);
        }
        return false;
    }

    @Override
    public Optional<RoleDO> queryRoleLinkRoleRelatePermission(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        return Optional.ofNullable(customRoleDOMapper.queryRoleLinkRoleRelatePermission(id));
    }
}
