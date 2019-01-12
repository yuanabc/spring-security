package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.ChannelPermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomChannelPermissionDOMapper {

    /**
     * 批量添加渠道权限
     * @param param 渠道权限数据
     * @return 添加数量
     */
    int insertList(@Param("param") List<ChannelPermissionDO> param);
}
