package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.FrontLogDO;
import com.ybinsure.icar.user.model.data.FrontLogDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrontLogDOMapper {
    long countByExample(FrontLogDOExample example);

    int deleteByExample(FrontLogDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FrontLogDO record);

    int insertSelective(FrontLogDO record);

    List<FrontLogDO> selectByExample(FrontLogDOExample example);

    FrontLogDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FrontLogDO record, @Param("example") FrontLogDOExample example);

    int updateByExample(@Param("record") FrontLogDO record, @Param("example") FrontLogDOExample example);

    int updateByPrimaryKeySelective(FrontLogDO record);

    int updateByPrimaryKey(FrontLogDO record);
}