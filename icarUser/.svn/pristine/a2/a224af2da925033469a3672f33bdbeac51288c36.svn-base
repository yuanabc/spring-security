package com.ybinsure.icar.user.mapper.data;

import com.ybinsure.icar.user.model.data.FeedbackDO;
import com.ybinsure.icar.user.model.data.FeedbackDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDOMapper {
    long countByExample(FeedbackDOExample example);

    int deleteByExample(FeedbackDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackDO record);

    int insertSelective(FeedbackDO record);

    List<FeedbackDO> selectByExampleWithBLOBs(FeedbackDOExample example);

    List<FeedbackDO> selectByExample(FeedbackDOExample example);

    FeedbackDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackDO record, @Param("example") FeedbackDOExample example);

    int updateByExampleWithBLOBs(@Param("record") FeedbackDO record, @Param("example") FeedbackDOExample example);

    int updateByExample(@Param("record") FeedbackDO record, @Param("example") FeedbackDOExample example);

    int updateByPrimaryKeySelective(FeedbackDO record);

    int updateByPrimaryKeyWithBLOBs(FeedbackDO record);

    int updateByPrimaryKey(FeedbackDO record);
}