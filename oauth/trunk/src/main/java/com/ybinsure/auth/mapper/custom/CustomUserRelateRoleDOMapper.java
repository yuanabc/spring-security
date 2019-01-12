package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.UserRelateRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomUserRelateRoleDOMapper {

    /**
     * 批量添加人员与角色关联信息
     * @param param 人员与角色关联数据
     * @return 添加成功的行数
     */
    Integer insertList(@Param("param")List<UserRelateRoleDO> param);
}
