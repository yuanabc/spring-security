package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.param.AddressParam;
import com.ybinsure.icar.user.model.vo.AddressVO;

import java.util.Optional;

/**
 * 保单配送地址服务
 *
 * @author HANHT
 * @version 2018/7/7 17:06
 */
public interface AddressService {

    /**
     * 查询保单配送地址列表
     *
     * @param param 带分页的入参
     * @return 分页查询结果
     */
    Optional<PageInfo<AddressVO>> queryAddressByUser(PageInfo param);

    /**
     * 添加保单配送地址
     *
     * @param param 添加入参
     * @return 添加是否成功
     */
    boolean addAddress(AddressParam param);

    /**
     * 修改保单配送地址
     *
     * @param param 修改入参
     * @return 修改是否成功
     */
    boolean updateAddress(AddressParam param);

    /**
     * 删除保单配送地址
     *
     * @param param 删除入参
     * @return 删除是否成功
     */
    boolean deleteAddress(AddressParam param);
}
