package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.PolicyAreaDO;
import com.ybinsure.auth.model.data.PolicyAreaDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PolicyAreaDOMapper {
    long countByExample(PolicyAreaDOExample example);

    int deleteByExample(PolicyAreaDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(PolicyAreaDO record);

    int insertSelective(PolicyAreaDO record);

    List<PolicyAreaDO> selectByExample(PolicyAreaDOExample example);

    PolicyAreaDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PolicyAreaDO record, @Param("example") PolicyAreaDOExample example);

    int updateByExample(@Param("record") PolicyAreaDO record, @Param("example") PolicyAreaDOExample example);

    int updateByPrimaryKeySelective(PolicyAreaDO record);

    int updateByPrimaryKey(PolicyAreaDO record);
}