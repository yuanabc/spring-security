package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.FileDO;
import com.ybinsure.icar.user.model.data.FileDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDOMapper {
    long countByExample(FileDOExample example);

    int deleteByExample(FileDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileDO record);

    int insertSelective(FileDO record);

    List<FileDO> selectByExample(FileDOExample example);

    FileDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileDO record, @Param("example") FileDOExample example);

    int updateByExample(@Param("record") FileDO record, @Param("example") FileDOExample example);

    int updateByPrimaryKeySelective(FileDO record);

    int updateByPrimaryKey(FileDO record);
}