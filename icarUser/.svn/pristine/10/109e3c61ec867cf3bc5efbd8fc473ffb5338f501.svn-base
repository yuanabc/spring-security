package com.ybinsure.icar.user.mapper.extend;

import com.github.pagehelper.Page;
import com.ybinsure.icar.user.mapper.data.CustomerDOMapper;
import com.ybinsure.icar.user.model.data.CustomerDO;
import com.ybinsure.icar.user.model.dto.CustomerDTO;
import com.ybinsure.icar.user.model.vo.CustomerVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 客户管理查询扩展
 *
 * @author HANHT
 * @version 2018/7/7 11:52
 */
@Repository
public interface CustomerExtendMapper extends CustomerDOMapper {

    /**
     * 查询客户列表数据
     *
     * @param dto 入参对象
     * @return 客户数据
     */
    Page<CustomerVO> selectCustomers(@Param("record") CustomerDTO dto);

    /**
     * 检验客户数据是否已存在
     *
     * @param record 入参对象
     * @return 数据量
     */
    int checkCustomer(@Param("record") CustomerDO record);
}
