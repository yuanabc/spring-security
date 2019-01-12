package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.ClientDO;
import com.ybinsure.auth.model.data.ClientDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientDOMapper {
    long countByExample(ClientDOExample example);

    int deleteByExample(ClientDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClientDO record);

    int insertSelective(ClientDO record);

    List<ClientDO> selectByExample(ClientDOExample example);

    ClientDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClientDO record, @Param("example") ClientDOExample example);

    int updateByExample(@Param("record") ClientDO record, @Param("example") ClientDOExample example);

    int updateByPrimaryKeySelective(ClientDO record);

    int updateByPrimaryKey(ClientDO record);
}