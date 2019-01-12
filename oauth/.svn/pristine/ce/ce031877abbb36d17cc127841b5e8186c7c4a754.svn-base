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
     * 查询渠道关联的特定人员信息，人员信息包含人员和角色信息
     * @param id 渠道id
     * @param userType 用户分类
     * @return 查询数据
     */
    ChannelDO queryChannelLinkUserAndLinkRoleById(@Param("id") String id, @Param("userType") String userType);

    /**
     * 分页查询渠道数据
     * @param pageParam 分页查询入参
     * @return 渠道信息
     */
    List<ChannelDO> queryPage(@Param("param") PageParam<ChannelQueryPageParamDTO> pageParam);
}
