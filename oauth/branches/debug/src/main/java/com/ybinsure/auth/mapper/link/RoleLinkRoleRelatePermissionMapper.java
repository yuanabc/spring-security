package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.link.RoleExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleLinkRoleRelatePermissionMapper {

    RoleExtend query(@Param("id") String id);

    /**
     * 删除渠道内角色关联权限信息中不在指定权限项内的权限
     * @param channelCode 渠道编码
     * @param excludePermissionIds 不删除的权限项范围
     * @return 删除数量
     */
    Integer deleteUserRelatePermission(@Param("channelCode") String channelCode, @Param("permissionIds")List<String> excludePermissionIds);

    /**
     * 检查渠道内角色关联权限信息中不在指定权限内的权限数量
     * @param channelCode 渠道编码
     * @param excludePermissionIds 指定权限
     * @return 查询数量
     */
    Integer countUserRelatePermission(@Param("channelCode") String channelCode, @Param("permissionIds")List<String> excludePermissionIds);
}
