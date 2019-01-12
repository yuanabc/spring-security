package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.mapper.data.RoleRelatePermissionDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendRoleRelatePermissionDOMapper;
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
    private final ExtendRoleRelatePermissionDOMapper extendRoleRelatePermissionDOMapper;

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
        return extendRoleRelatePermissionDOMapper.insertList(list) == list.size();
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

}
