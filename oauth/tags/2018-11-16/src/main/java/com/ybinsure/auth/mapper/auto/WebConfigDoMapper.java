package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.WebConfigDO;
import com.ybinsure.auth.model.data.WebConfigDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WebConfigDoMapper {
    long countByExample(WebConfigDoExample example);

    int deleteByExample(WebConfigDoExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebConfigDO record);

    int insertSelective(WebConfigDO record);

    List<WebConfigDO> selectByExample(WebConfigDoExample example);

    WebConfigDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebConfigDO record, @Param("example") WebConfigDoExample example);

    int updateByExample(@Param("record") WebConfigDO record, @Param("example") WebConfigDoExample example);

    int updateByPrimaryKeySelective(WebConfigDO record);

    int updateByPrimaryKey(WebConfigDO record);
}