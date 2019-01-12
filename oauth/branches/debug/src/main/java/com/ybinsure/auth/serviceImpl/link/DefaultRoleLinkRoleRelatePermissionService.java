package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.link.RoleLinkRoleRelatePermissionMapper;
import com.ybinsure.auth.model.data.RoleRelatePermissionDO;
import com.ybinsure.auth.model.link.RoleExtend;
import com.ybinsure.auth.service.data.RoleRelatePermissionService;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.service.link.RoleLinkRoleRelatePermissionService;
import com.ybinsure.auth.service.link.UserLinkUserRelateRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultRoleLinkRoleRelatePermissionService implements RoleLinkRoleRelatePermissionService {

    private final RoleService roleService;
    private final RoleRelatePermissionService roleRelatePermissionService;
    private final RoleLinkRoleRelatePermissionMapper roleLinkRoleRelatePermissionMapper;
    private final UserLinkUserRelateRoleService userLinkUserRelateRoleService;

    @Override
    @Transactional
    public Optional<String> insert(RoleExtend param) {
        Optional<String> insertRoleOptional = roleService.insert(param);
        if (insertRoleOptional.isPresent()) {
            param.getRoleRelatePermissionDOS().forEach(roleRelatePermissionDO -> roleRelatePermissionDO.setRoleId(param.getId()));
            if (roleRelatePermissionService.insertList(param.getRoleRelatePermissionDOS())) {
                return insertRoleOptional;
            }
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public boolean update(RoleExtend param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        if (!roleRelatePermissionService.deleteByRoleId(param.getId())) {
            throw FailResultException.nonError("删除原有关联权限失败, ");
        }
        param.getRoleRelatePermissionDOS().forEach(value -> value.setRoleId(param.getId()));
        if (!roleRelatePermissionService.insertList(param.getRoleRelatePermissionDOS())) {
            throw FailResultException.nonError("添加新关联权限失败, ");
        }
        if (!roleService.update(param)) {
            throw FailResultException.nonError("更新角色信息失败, ");
        }
        if (userLinkUserRelateRoleService.isAdminRole(param.getChannelCode(), param.getId())) {
            List<String> permissionIds = param.getRoleRelatePermissionDOS().stream().map(RoleRelatePermissionDO::getPermissionId).collect(Collectors.toList());
            if (permissionIds.isEmpty()) {
                permissionIds = null;
            }
            roleLinkRoleRelatePermissionMapper.deleteUserRelatePermission(param.getChannelCode(), permissionIds);
            if (roleLinkRoleRelatePermissionMapper.countUserRelatePermission(param.getChannelCode(), permissionIds) > 0) {
                throw FailResultException.nonError("收回渠道权限项失败, ");
            }
        }
        return true;
    }

    @Override
    public Optional<RoleExtend> query(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        return Optional.ofNullable(roleLinkRoleRelatePermissionMapper.query(id));
    }
}
