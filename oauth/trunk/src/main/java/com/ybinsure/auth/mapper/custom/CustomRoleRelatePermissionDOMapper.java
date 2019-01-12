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
}
