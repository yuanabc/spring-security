package com.ybinsure.icar.user.mapper.extend;

import com.github.pagehelper.Page;
import com.ybinsure.icar.user.mapper.data.AddressDOMapper;
import com.ybinsure.icar.user.model.vo.AddressVO;
import org.springframework.stereotype.Repository;

/**
 * 保单配送地址查询扩展
 *
 * @author HANHT
 * @version 2018/7/7 17:34
 */
@Repository
public interface AddressExtendMapper extends AddressDOMapper {

    /**
     * 查询用户地址列表
     *
     * @param auth 用户编号
     * @return 地址分页列表数据
     */
    Page<AddressVO> selectAddressByUser(String auth);
}
