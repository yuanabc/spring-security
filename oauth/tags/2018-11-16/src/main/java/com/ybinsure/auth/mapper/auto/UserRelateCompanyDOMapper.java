package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import com.ybinsure.auth.model.data.UserRelateCompanyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRelateCompanyDOMapper {
    long countByExample(UserRelateCompanyDOExample example);

    int deleteByExample(UserRelateCompanyDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRelateCompanyDO record);

    int insertSelective(UserRelateCompanyDO record);

    List<UserRelateCompanyDO> selectByExample(UserRelateCompanyDOExample example);

    UserRelateCompanyDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRelateCompanyDO record, @Param("example") UserRelateCompanyDOExample example);

    int updateByExample(@Param("record") UserRelateCompanyDO record, @Param("example") UserRelateCompanyDOExample example);

    int updateByPrimaryKeySelective(UserRelateCompanyDO record);

    int updateByPrimaryKey(UserRelateCompanyDO record);
}