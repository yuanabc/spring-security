package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.PolicyDO;
import com.ybinsure.icar.user.model.data.PolicyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyDOMapper {
    long countByExample(PolicyDOExample example);

    int deleteByExample(PolicyDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(PolicyDO record);

    int insertSelective(PolicyDO record);

    List<PolicyDO> selectByExample(PolicyDOExample example);

    PolicyDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PolicyDO record, @Param("example") PolicyDOExample example);

    int updateByExample(@Param("record") PolicyDO record, @Param("example") PolicyDOExample example);

    int updateByPrimaryKeySelective(PolicyDO record);

    int updateByPrimaryKey(PolicyDO record);
}