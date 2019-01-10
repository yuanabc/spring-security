package com.ybinsure.icar.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.ybinsure.icar.user.constant.DefaultConst;
import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.exception.FailResultException;
import com.ybinsure.icar.user.mapper.extend.CustomerExtendMapper;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.data.CustomerDO;
import com.ybinsure.icar.user.model.dto.CustomerDTO;
import com.ybinsure.icar.user.model.param.CustomerParam;
import com.ybinsure.icar.user.model.vo.CustomerVO;
import com.ybinsure.icar.user.service.data.CustomerService;
import com.ybinsure.icar.user.util.DateUtil;
import com.ybinsure.icar.user.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * 客户管理服务实现
 *
 * @author HANHT
 * @version 2018/7/7 19:21
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerExtendMapper customerExtendMapper;

    @Autowired
    public CustomerServiceImpl(CustomerExtendMapper customerExtendMapper) {
        this.customerExtendMapper = customerExtendMapper;
    }

    @Override
    public Optional<PageInfo<CustomerVO>> queryCustomers(QueryParam param) {
        param.setOrderBy("id");
        param.setSortord(1);

        PageHelper.startPage(param.getPageNum(), param.getPageSize(), param.assembleSort());

        CustomerDTO dto = new CustomerDTO();
        dto.setUserId(param.getAuth());
        dto.setLicenseNo(param.getLicenseNo());
        dto.setOwnerName(param.getOwnerName());
        // 到期日期
        if (param.getDueDays() != null) {
            dto.setToday(DateUtil.today());
            dto.setDueDay(DateUtil.addDay(param.getDueDays()));
        }

        return Optional.of(PageInfo.instance(customerExtendMapper.selectCustomers(dto)));
    }

    @Override
    public Optional<CustomerVO> queryCustomer(CustomerParam param) {
        CustomerDO customerDO = customerExtendMapper.selectByPrimaryKey(param.getCustomerId());
        // 没有查到结果或查询结果不是当前用户的
        if (customerDO == null || !Objects.equals(customerDO.getSalesmanId(), param.getAuth())) {

            return Optional.empty();
        }

        CustomerVO vo = new CustomerVO();
        vo.setCustomerId(customerDO.getId());
        vo.setTciEndDate(customerDO.getForceEndDate());
        vo.setVciEndDate(customerDO.getComEndDate());
        vo.setLicenseNo(customerDO.getLicenseNo());
        vo.setOwnerName(customerDO.getName());
        vo.setOwnerPhone(StrUtil.defaultIfNull(customerDO.getPhone(), ""));
        vo.setFrameNo(customerDO.getVinNo());
        vo.setBrandName(customerDO.getModelName());
        vo.setRemark(customerDO.getRemark());
        vo.setLastCompanyId(customerDO.getLastCompanyId());

        return Optional.of(vo);
    }

    @Override
    public boolean addCustomer(CustomerParam param) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setSalesmanId(param.getAuth());
        customerDO.setLicenseNo(param.getLicenseNo());
        customerDO.setVinNo(param.getFrameNo());
        // 新车未上牌除外
        if (!Objects.equals(DefaultConst.NEW_CAR, customerDO.getLicenseNo())) {
            // 校验数据是否已存在
            if (customerExtendMapper.checkCustomer(customerDO) > 0) {

                throw FailResultException.dataExistException();
            }
        }

        customerDO.setName(param.getOwnerName());
        customerDO.setPhone(StrUtil.toLong(param.getOwnerPhone(), 0));
        customerDO.setModelName(param.getBrandName());
        customerDO.setLastCompanyId(param.getLastCompanyId());
        if (StrUtil.isNotBlank(param.getVciEndDate())) {
            customerDO.setComEndDate(DateUtil.toDate(param.getVciEndDate()));
        }
        if (StrUtil.isNotBlank(param.getTciEndDate())) {
            customerDO.setForceEndDate(DateUtil.toDate(param.getTciEndDate()));
        }
        customerDO.setRemark(param.getRemark());

        return customerExtendMapper.insertSelective(customerDO) > 0;
    }

    @Override
    public boolean updateCustomer(CustomerParam param) {
        // 校验数据是否存在
        CustomerDO res = customerExtendMapper.selectByPrimaryKey(param.getCustomerId());
        if (res == null || !Objects.equals(res.getSalesmanId(), param.getAuth())) {

            throw FailResultException.dataNoExistException();
        }

        CustomerDO customerDO = new CustomerDO();
        customerDO.setId(res.getId());
        customerDO.setLicenseNo(param.getLicenseNo());
        customerDO.setVinNo(param.getFrameNo());
        // 如果修改车牌信息，校验是否存在，新车未上牌除外
        if (StrUtil.isNotBlank(param.getLicenseNo()) && !Objects.equals(DefaultConst.NEW_CAR, customerDO.getLicenseNo())) {
            // 校验数据是否已存在
            if (customerExtendMapper.checkCustomer(customerDO) > 0) {

                throw FailResultException.dataExistException();
            }
        }

        customerDO.setName(param.getOwnerName());
        customerDO.setPhone(StrUtil.toLong(param.getOwnerPhone(), 0));
        customerDO.setModelName(param.getBrandName());
        customerDO.setLastCompanyId(param.getLastCompanyId());
        if (StrUtil.isNotBlank(param.getVciEndDate())) {
            customerDO.setComEndDate(DateUtil.toDate(param.getVciEndDate()));
        }
        if (StrUtil.isNotBlank(param.getTciEndDate())) {
            customerDO.setForceEndDate(DateUtil.toDate(param.getTciEndDate()));
        }
        customerDO.setRemark(param.getRemark());

        return customerExtendMapper.updateByPrimaryKeySelective(customerDO) > 0;
    }

    @Override
    public boolean deleteCustomer(CustomerParam param) {
        // 校验数据是否存在
        CustomerDO res = customerExtendMapper.selectByPrimaryKey(param.getCustomerId());
        if (res == null || !Objects.equals(res.getSalesmanId(), param.getAuth())) {

            throw FailResultException.dataNoExistException();
        }

        CustomerDO customerDO = new CustomerDO();
        customerDO.setId(res.getId());
        customerDO.setDel(SwitchCode.ENABLE);

        return customerExtendMapper.updateByPrimaryKeySelective(customerDO) > 0;
    }
}
