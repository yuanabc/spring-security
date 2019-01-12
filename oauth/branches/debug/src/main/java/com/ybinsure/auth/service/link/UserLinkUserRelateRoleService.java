package com.ybinsure.auth.service.link;

public interface UserLinkUserRelateRoleService {

    /**
     * 检查角色是否是渠道admin角色
     */
    boolean isAdminRole(String channelCode, String roleId);


}
