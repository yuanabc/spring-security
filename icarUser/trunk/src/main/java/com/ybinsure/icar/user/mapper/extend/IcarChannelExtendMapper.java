package com.ybinsure.icar.user.mapper.extend;

import com.ybinsure.icar.user.mapper.data.IcarChannelDOMapper;
import com.ybinsure.icar.user.model.data.IcarChannelDO;
import com.ybinsure.icar.user.model.dto.IcarChannelDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IcarChannelExtendMapper extends IcarChannelDOMapper {

    /**
     * 查询续保用工号
     *
     * @param dto 查询条件
     * @return 工号集合
     */
    Set<IcarChannelDO> selectRenewalChannel(@Param("record") IcarChannelDTO dto);

    /**
     * 随机查询用户渠道平安工号
     *
     * @param userId 用户id
     * @return 工号
     */
    IcarChannelDO selectPingAnChannel(String userId);
}