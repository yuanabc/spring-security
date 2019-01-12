package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.CompanyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyDOMapper {
    long countByExample(CompanyDOExample example);

    int deleteByExample(CompanyDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyDO record);

    int insertSelective(CompanyDO record);

    List<CompanyDO> selectByExample(CompanyDOExample example);

    CompanyDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyDO record, @Param("example") CompanyDOExample example);

    int updateByExample(@Param("record") CompanyDO record, @Param("example") CompanyDOExample example);

    int updateByPrimaryKeySelective(CompanyDO record);

    int updateByPrimaryKey(CompanyDO record);
}