package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.PropertyTypeDO;
import com.ybinsure.auth.model.data.PropertyTypeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PropertyTypeDOMapper {
    long countByExample(PropertyTypeDOExample example);

    int deleteByExample(PropertyTypeDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(PropertyTypeDO record);

    int insertSelective(PropertyTypeDO record);

    List<PropertyTypeDO> selectByExample(PropertyTypeDOExample example);

    PropertyTypeDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PropertyTypeDO record, @Param("example") PropertyTypeDOExample example);

    int updateByExample(@Param("record") PropertyTypeDO record, @Param("example") PropertyTypeDOExample example);

    int updateByPrimaryKeySelective(PropertyTypeDO record);

    int updateByPrimaryKey(PropertyTypeDO record);
}