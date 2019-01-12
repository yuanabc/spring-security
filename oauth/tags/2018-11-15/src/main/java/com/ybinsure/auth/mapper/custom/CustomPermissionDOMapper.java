package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.PermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomPermissionDOMapper {

    /**
     * 查询角色关联的权限信息
     * @param roleId 角色id
     * @return 权限信息
     */
    List<PermissionDO> queryByRoleId(@Param("roleId") String roleId);

    /**
     * 查询用户关联的权限信息
     * @param userId 用户id
     * @return 权限信息
     */
    List<PermissionDO> queryByUserId(@Param("userId")String userId);
}
