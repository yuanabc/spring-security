package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.ClientRelateResourceDO;
import com.ybinsure.auth.model.data.ClientRelateResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientRelateResourceDOMapper {
    long countByExample(ClientRelateResourceDOExample example);

    int deleteByExample(ClientRelateResourceDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClientRelateResourceDO record);

    int insertSelective(ClientRelateResourceDO record);

    List<ClientRelateResourceDO> selectByExample(ClientRelateResourceDOExample example);

    ClientRelateResourceDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClientRelateResourceDO record, @Param("example") ClientRelateResourceDOExample example);

    int updateByExample(@Param("record") ClientRelateResourceDO record, @Param("example") ClientRelateResourceDOExample example);

    int updateByPrimaryKeySelective(ClientRelateResourceDO record);

    int updateByPrimaryKey(ClientRelateResourceDO record);
}