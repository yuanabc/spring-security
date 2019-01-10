package com.ybinsure.icar.user.mapper.extend;

import com.github.pagehelper.Page;
import com.ybinsure.icar.user.mapper.data.PingAnOrderDOMapper;
import com.ybinsure.icar.user.model.data.PingAnOrderDO;
import com.ybinsure.icar.user.model.data.PingAnOrderDOExample;
import org.springframework.stereotype.Repository;

/**
 * 云南平安订单服务扩展
 *
 * @author HANHT
 * @version 2018/7/15 14:13
 */
@Repository
public interface PingAnOrderExtendMapper extends PingAnOrderDOMapper {

    /**
     * 查询平安订单列表数据
     *
     * @param example 入参对象
     * @return 平安订单数据
     */
    Page<PingAnOrderDO> selectUserOrder(PingAnOrderDOExample example);
}