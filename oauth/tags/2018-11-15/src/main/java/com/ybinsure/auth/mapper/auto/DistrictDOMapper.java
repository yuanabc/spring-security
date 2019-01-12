package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.data.DistrictDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DistrictDOMapper {
    long countByExample(DistrictDOExample example);

    int deleteByExample(DistrictDOExample example);

    int deleteByPrimaryKey(Short id);

    int insert(DistrictDO record);

    int insertSelective(DistrictDO record);

    List<DistrictDO> selectByExample(DistrictDOExample example);

    DistrictDO selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") DistrictDO record, @Param("example") DistrictDOExample example);

    int updateByExample(@Param("record") DistrictDO record, @Param("example") DistrictDOExample example);

    int updateByPrimaryKeySelective(DistrictDO record);

    int updateByPrimaryKey(DistrictDO record);
}