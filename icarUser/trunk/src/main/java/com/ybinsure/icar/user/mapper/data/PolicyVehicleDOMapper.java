package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.PolicyVehicleDO;
import com.ybinsure.icar.user.model.data.PolicyVehicleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyVehicleDOMapper {
    long countByExample(PolicyVehicleDOExample example);

    int deleteByExample(PolicyVehicleDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PolicyVehicleDO record);

    int insertSelective(PolicyVehicleDO record);

    List<PolicyVehicleDO> selectByExample(PolicyVehicleDOExample example);

    PolicyVehicleDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PolicyVehicleDO record, @Param("example") PolicyVehicleDOExample example);

    int updateByExample(@Param("record") PolicyVehicleDO record, @Param("example") PolicyVehicleDOExample example);

    int updateByPrimaryKeySelective(PolicyVehicleDO record);

    int updateByPrimaryKey(PolicyVehicleDO record);
}