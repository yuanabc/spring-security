package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.MessageDO;
import com.ybinsure.icar.user.model.data.MessageDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDOMapper {
    long countByExample(MessageDOExample example);

    int deleteByExample(MessageDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageDO record);

    int insertSelective(MessageDO record);

    List<MessageDO> selectByExample(MessageDOExample example);

    MessageDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageDO record, @Param("example") MessageDOExample example);

    int updateByExample(@Param("record") MessageDO record, @Param("example") MessageDOExample example);

    int updateByPrimaryKeySelective(MessageDO record);

    int updateByPrimaryKey(MessageDO record);
}