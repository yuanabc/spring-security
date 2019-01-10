package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.param.CustomerParam;
import com.ybinsure.icar.user.model.vo.CustomerVO;

import java.util.Optional;

/**
 * 客户管理服务
 *
 * @author HANHT
 * @version 2018/7/7 19:20
 */
public interface CustomerService {

    /**
     * 查询客户列表
     *
     * @param param 带条件分页的入参
     * @return 分页查询结果
     */
    Optional<PageInfo<CustomerVO>> queryCustomers(QueryParam param);

    /**
     * 查询客户信息
     *
     * @param param 查询数据
     * @return 是否查询成功
     */
    Optional<CustomerVO> queryCustomer(CustomerParam param);

    /**
     * 添加客户信息
     *
     * @param param 添加数据
     * @return 是否添加成功
     */
    boolean addCustomer(CustomerParam param);

    /**
     * 修改客户信息
     *
     * @param param 修改数据
     * @return 是否修改成功
     */
    boolean updateCustomer(CustomerParam param);

    /**
     * 删除客户信息
     *
     * @param param 删除数据
     * @return 是否删除成功
     */
    boolean deleteCustomer(CustomerParam param);
}
