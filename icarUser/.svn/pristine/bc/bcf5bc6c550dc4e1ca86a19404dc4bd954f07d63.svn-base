package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.AddressDO;
import com.ybinsure.icar.user.model.data.AddressDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressDOMapper {
    long countByExample(AddressDOExample example);

    int deleteByExample(AddressDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressDO record);

    int insertSelective(AddressDO record);

    List<AddressDO> selectByExample(AddressDOExample example);

    AddressDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressDO record, @Param("example") AddressDOExample example);

    int updateByExample(@Param("record") AddressDO record, @Param("example") AddressDOExample example);

    int updateByPrimaryKeySelective(AddressDO record);

    int updateByPrimaryKey(AddressDO record);
}