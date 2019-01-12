package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.RoleDO;
import org.apache.ibatis.annotations.Param;

public interface CustomRoleDOMapper {

    /**
     * 查询角色以及关联的角色与权限关联数据
     * @param id 角色id
     * @return 角色以及关联的角色与权限关联数据
     */
    RoleDO queryRoleLinkRoleRelatePermission(@Param("id") String id);
}
