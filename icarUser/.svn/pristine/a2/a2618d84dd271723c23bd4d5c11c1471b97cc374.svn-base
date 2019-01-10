package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.PolicyRiskDO;
import com.ybinsure.icar.user.model.data.PolicyRiskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRiskDOMapper {
    long countByExample(PolicyRiskDOExample example);

    int deleteByExample(PolicyRiskDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PolicyRiskDO record);

    int insertSelective(PolicyRiskDO record);

    List<PolicyRiskDO> selectByExample(PolicyRiskDOExample example);

    PolicyRiskDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PolicyRiskDO record, @Param("example") PolicyRiskDOExample example);

    int updateByExample(@Param("record") PolicyRiskDO record, @Param("example") PolicyRiskDOExample example);

    int updateByPrimaryKeySelective(PolicyRiskDO record);

    int updateByPrimaryKey(PolicyRiskDO record);
}