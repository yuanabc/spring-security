package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.ClientRelateGrantTypesDO;
import com.ybinsure.auth.model.data.ClientRelateGrantTypesDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientRelateGrantTypesDOMapper {
    long countByExample(ClientRelateGrantTypesDOExample example);

    int deleteByExample(ClientRelateGrantTypesDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClientRelateGrantTypesDO record);

    int insertSelective(ClientRelateGrantTypesDO record);

    List<ClientRelateGrantTypesDO> selectByExample(ClientRelateGrantTypesDOExample example);

    ClientRelateGrantTypesDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClientRelateGrantTypesDO record, @Param("example") ClientRelateGrantTypesDOExample example);

    int updateByExample(@Param("record") ClientRelateGrantTypesDO record, @Param("example") ClientRelateGrantTypesDOExample example);

    int updateByPrimaryKeySelective(ClientRelateGrantTypesDO record);

    int updateByPrimaryKey(ClientRelateGrantTypesDO record);
}