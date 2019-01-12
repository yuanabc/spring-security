package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.RoleRelatePermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomRoleRelatePermissionDOMapper {

    /**
     * 批量添加角色与权限关联数据
     * @param param 角色与权限关联数据
     * @return 添加成功的数据数量
     */
    Integer insertList(@Param("param")List<RoleRelatePermissionDO> param);

    /**
     * 删除渠道内角色关联权限信息中不在指定权限项内的权限
     * @param channelCode 渠道编码
     * @param excludePermissionIds 不删除的权限项范围
     * @return 删除数量
     */
    // todo remove
    Integer deleteUserRelatePermission(@Param("channelCode") String channelCode, @Param("permissionIds")List<String> excludePermissionIds);

    /**
     * 检查渠道内角色关联权限信息中不在指定权限内的权限数量
     * @param channelCode 渠道编码
     * @param excludePermissionIds 指定权限
     * @return 查询数量
     */
    // todo remove
    Integer countUserRelatePermission(@Param("channelCode") String channelCode, @Param("permissionIds")List<String> excludePermissionIds);
}
