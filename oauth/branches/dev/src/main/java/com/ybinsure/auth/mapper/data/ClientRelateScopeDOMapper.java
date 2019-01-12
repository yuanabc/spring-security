package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.ClientRelateScopeDO;
import com.ybinsure.auth.model.data.ClientRelateScopeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientRelateScopeDOMapper {
    long countByExample(ClientRelateScopeDOExample example);

    int deleteByExample(ClientRelateScopeDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClientRelateScopeDO record);

    int insertSelective(ClientRelateScopeDO record);

    List<ClientRelateScopeDO> selectByExample(ClientRelateScopeDOExample example);

    ClientRelateScopeDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClientRelateScopeDO record, @Param("example") ClientRelateScopeDOExample example);

    int updateByExample(@Param("record") ClientRelateScopeDO record, @Param("example") ClientRelateScopeDOExample example);

    int updateByPrimaryKeySelective(ClientRelateScopeDO record);

    int updateByPrimaryKey(ClientRelateScopeDO record);
}