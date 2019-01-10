package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.IcarSysLogDO;
import com.ybinsure.icar.user.model.data.IcarSysLogDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IcarSysLogDOMapper {
    long countByExample(IcarSysLogDOExample example);

    int deleteByExample(IcarSysLogDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IcarSysLogDO record);

    int insertSelective(IcarSysLogDO record);

    List<IcarSysLogDO> selectByExample(IcarSysLogDOExample example);

    IcarSysLogDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IcarSysLogDO record, @Param("example") IcarSysLogDOExample example);

    int updateByExample(@Param("record") IcarSysLogDO record, @Param("example") IcarSysLogDOExample example);

    int updateByPrimaryKeySelective(IcarSysLogDO record);

    int updateByPrimaryKey(IcarSysLogDO record);
}