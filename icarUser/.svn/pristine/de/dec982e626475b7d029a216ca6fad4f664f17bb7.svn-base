package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.PolicyApplicantDO;
import com.ybinsure.icar.user.model.data.PolicyApplicantDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyApplicantDOMapper {
    long countByExample(PolicyApplicantDOExample example);

    int deleteByExample(PolicyApplicantDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PolicyApplicantDO record);

    int insertSelective(PolicyApplicantDO record);

    List<PolicyApplicantDO> selectByExample(PolicyApplicantDOExample example);

    PolicyApplicantDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PolicyApplicantDO record, @Param("example") PolicyApplicantDOExample example);

    int updateByExample(@Param("record") PolicyApplicantDO record, @Param("example") PolicyApplicantDOExample example);

    int updateByPrimaryKeySelective(PolicyApplicantDO record);

    int updateByPrimaryKey(PolicyApplicantDO record);
}