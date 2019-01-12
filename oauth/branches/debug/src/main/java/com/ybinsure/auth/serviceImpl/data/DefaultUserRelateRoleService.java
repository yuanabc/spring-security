package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.mapper.data.UserRelateRoleDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendUserRelateRoleDOMapper;
import com.ybinsure.auth.model.data.UserRelateRoleDO;
import com.ybinsure.auth.model.data.UserRelateRoleDOExample;
import com.ybinsure.auth.service.data.UserRelateRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserRelateRoleService implements UserRelateRoleService {

    private final UserRelateRoleDOMapper userRelateRoleDOMapper;
    private final ExtendUserRelateRoleDOMapper extendUserRelateRoleDOMapper;

    @Override
    public Optional<String> insert(UserRelateRoleDO param) {
        if (!(StringUtils.isNotBlank(param.getUserId()) &&
                StringUtils.isNotBlank(param.getRoleId()))) {
            return Optional.empty();
        }
        if (userRelateRoleDOMapper.insert(param) > 0) {
            return Optional.of(param.getId());
        }
        return Optional.empty();
    }

    @Override
    public boolean insertList(List<UserRelateRoleDO> params) {
        if (params == null || params.isEmpty()) {
            return true;
        }
        return extendUserRelateRoleDOMapper.insertList(params) == params.size();
    }

    @Override
    public boolean deleteByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return false;
        }
        UserRelateRoleDOExample example = new UserRelateRoleDOExample();
        example.or().andUserIdEqualTo(userId);
        userRelateRoleDOMapper.deleteByExample(example);
        return userRelateRoleDOMapper.countByExample(example) == 0;
    }

    @Override
    public boolean deleteByRoleId(String roleId) {
        if (StringUtils.isBlank(roleId)) {
            return false;
        }
        UserRelateRoleDOExample example = new UserRelateRoleDOExample();
        example.or().andRoleIdEqualTo(roleId);
        userRelateRoleDOMapper.deleteByExample(example);
        return userRelateRoleDOMapper.countByExample(example) == 0;
    }

    @Override
    public Optional<List<UserRelateRoleDO>> queryByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return Optional.empty();
        }
        UserRelateRoleDOExample example = new UserRelateRoleDOExample();
        example.or().andUserIdEqualTo(userId);
        return Optional.ofNullable(this.userRelateRoleDOMapper.selectByExample(example));
    }

}
