package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.PingAnOrderDO;
import com.ybinsure.icar.user.model.data.PingAnOrderDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PingAnOrderDOMapper {
    long countByExample(PingAnOrderDOExample example);

    int deleteByExample(PingAnOrderDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PingAnOrderDO record);

    int insertSelective(PingAnOrderDO record);

    List<PingAnOrderDO> selectByExample(PingAnOrderDOExample example);

    PingAnOrderDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PingAnOrderDO record, @Param("example") PingAnOrderDOExample example);

    int updateByExample(@Param("record") PingAnOrderDO record, @Param("example") PingAnOrderDOExample example);

    int updateByPrimaryKeySelective(PingAnOrderDO record);

    int updateByPrimaryKey(PingAnOrderDO record);
}