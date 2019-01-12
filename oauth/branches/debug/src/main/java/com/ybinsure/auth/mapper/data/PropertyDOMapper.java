package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.PropertyDO;
import com.ybinsure.auth.model.data.PropertyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PropertyDOMapper {
    long countByExample(PropertyDOExample example);

    int deleteByExample(PropertyDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(PropertyDO record);

    int insertSelective(PropertyDO record);

    List<PropertyDO> selectByExample(PropertyDOExample example);

    PropertyDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PropertyDO record, @Param("example") PropertyDOExample example);

    int updateByExample(@Param("record") PropertyDO record, @Param("example") PropertyDOExample example);

    int updateByPrimaryKeySelective(PropertyDO record);

    int updateByPrimaryKey(PropertyDO record);
}