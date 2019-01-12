package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.ClientDO;
import org.apache.ibatis.annotations.Param;

public interface CustomClientMapper {

    /**
     * 根据client查询Client关联的所有信息
     * 关联信息包含grantTypes,resources,scopes
     * @param client client名称
     * @return 查询数据
     */
    ClientDO queryFullLinkedInfo(@Param("client") String client);
}
