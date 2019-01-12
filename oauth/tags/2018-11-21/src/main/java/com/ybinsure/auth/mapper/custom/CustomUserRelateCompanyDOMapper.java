package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomUserRelateCompanyDOMapper {

    /**
     * 批量添加人员与机构关联信息
     * @param param 人员与机构关联数据
     * @return 添加成功的记录数
     */
    Integer insertList(@Param("param")List<UserRelateCompanyDO> param);
}
