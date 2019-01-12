package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.param.ChannelQueryPageParamDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomChannelMapper {

    /**
     * 查询渠道最大的渠道编号
     * @return 最大的渠道编号
     */
    Integer queryMaxOrderCode();

    /**
     * 分页查询渠道数据
     * @param pageParam 分页查询入参
     * @return 渠道信息
     */
    List<ChannelDO> queryPage(@Param("param") PageParam<ChannelQueryPageParamDTO> pageParam);
}
