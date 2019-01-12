package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.mapper.auto.RoleRelatePermissionDOMapper;
import com.ybinsure.auth.mapper.custom.CustomRoleRelatePermissionDOMapper;
import com.ybinsure.auth.model.data.RoleRelatePermissionDO;
import com.ybinsure.auth.model.data.RoleRelatePermissionDOExample;
import com.ybinsure.auth.service.data.RoleRelatePermissionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultRoleRelatePermissionService implements RoleRelatePermissionService {

    private final RoleRelatePermissionDOMapper roleRelatePermissionDOMapper;
    private final CustomRoleRelatePermissionDOMapper customRoleRelatePermissionDOMapper;

    @Override
    public Optional<String> insert(RoleRelatePermissionDO param) {
        if (insertRequire(param)) {
            return Optional.empty();
        }
        if (roleRelatePermissionDOMapper.insertSelective(param) > 0) {
            return Optional.of(param.getId());
        }
        return Optional.empty();
    }

    @Override
    public boolean insertList(List<RoleRelatePermissionDO> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return customRoleRelatePermissionDOMapper.insertList(list) == list.size();
    }

    private boolean insertRequire(RoleRelatePermissionDO param) {
        return StringUtils.isBlank(param.getRoleId()) ||
                StringUtils.isBlank(param.getPermissionId());
    }

    @Override
    public boolean deleteByRoleId(String roleId) {
        RoleRelatePermissionDOExample example = new RoleRelatePermissionDOExample();
        example.or().andRoleIdEqualTo(roleId);
        roleRelatePermissionDOMapper.deleteByExample(example);
        return roleRelatePermissionDOMapper.selectByExample(example).isEmpty();
    }

        @Override
    public boolean deleteNotMatchPermissions(List<String> roleIds, List<String> permissionIds) {
        if (roleIds == null || roleIds.isEmpty() || permissionIds == null || permissionIds.isEmpty()) {
            return true;
        }
        RoleRelatePermissionDOExample example = new RoleRelatePermissionDOExample();
        example.or().andRoleIdIn(roleIds)
                .andPermissionIdNotIn(permissionIds);
        roleRelatePermissionDOMapper.deleteByExample(example);
        return roleRelatePermissionDOMapper.selectByExample(example).isEmpty();
    }

    @Override
    public boolean hasAnyNonePermission(String roleId, List<String> permissionIds) {
        if (StringUtils.isBlank(roleId) || permissionIds == null || permissionIds.isEmpty()) {
            return false;
        }
        RoleRelatePermissionDOExample example = new RoleRelatePermissionDOExample();
        example.or().andRoleIdEqualTo(roleId)
                .andPermissionIdIn(permissionIds);
        long size = roleRelatePermissionDOMapper.countByExample(example);
        return size < permissionIds.size();
    }

}
