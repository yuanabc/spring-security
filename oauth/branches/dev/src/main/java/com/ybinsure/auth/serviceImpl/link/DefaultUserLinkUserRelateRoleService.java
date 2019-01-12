package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.mapper.link.UserLinkUserRelateRoleMapper;
import com.ybinsure.auth.service.link.UserLinkUserRelateRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultUserLinkUserRelateRoleService implements UserLinkUserRelateRoleService {

    private final UserLinkUserRelateRoleMapper userLinkUserRelateRoleMapper;

    @Override
    public boolean isAdminRole(String channelCode, String roleId) {
        if (StringUtils.isBlank(channelCode) || StringUtils.isBlank(roleId)) {
            return false;
        }
        return userLinkUserRelateRoleMapper.queryByRoleId(UserTypeCode.ADMIN, channelCode, roleId) > 0;
    }
}
