package com.ybinsure.icar.user.controller.customer;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.annotation.DeleteAction;
import com.ybinsure.icar.user.annotation.InsertAction;
import com.ybinsure.icar.user.annotation.QueryAction;
import com.ybinsure.icar.user.annotation.UpdateAction;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.param.CustomerParam;
import com.ybinsure.icar.user.model.vo.CustomerVO;
import com.ybinsure.icar.user.model.vo.PolicyInfoVO;
import com.ybinsure.icar.user.service.data.CustomerService;
import com.ybinsure.icar.user.service.data.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户管理接口
 *
 * @author HANHT
 * @version 2018/7/7 19:24
 */
@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final PolicyService policyService;

    @Autowired
    public CustomerController(CustomerService customerService, PolicyService policyService) {
        this.customerService = customerService;
        this.policyService = policyService;
    }

    /**
     * 客户列表查询
     */
    @ControllerLog(description = "客户列表查询")
    @PostMapping(ApiPath.CUSTOMER_LIST)
    public ICarResult<PageInfo<CustomerVO>> listCustomer(@Validated QueryParam param) {

        return ICarResult.ok(customerService.queryCustomers(param).orElseGet(PageInfo::new));
    }

    /**
     * 查询客户信息
     */
    @ControllerLog(description = "查询客户信息")
    @PostMapping(ApiPath.CUSTOMER_QUERY)
    public ICarResult<CustomerVO> getCustomer(@Validated(QueryAction.class) CustomerParam param) {

        return customerService.queryCustomer(param).map(ICarResult::ok).orElseGet(ICarResult::fail);
    }

    /**
     * 添加客户信息
     */
    @ControllerLog(description = "添加客户信息")
    @PostMapping(ApiPath.CUSTOMER_ADD)
    public ICarResult addCustomer(@Validated(InsertAction.class) CustomerParam param) {

        return customerService.addCustomer(param) ? ICarResult.ok() : ICarResult.fail();
    }

    /**
     * 编辑客户信息
     */
    @ControllerLog(description = "编辑客户信息")
    @PostMapping(ApiPath.CUSTOMER_UPDATE)
    public ICarResult updateCustomer(@Validated(UpdateAction.class) CustomerParam param) {

        return customerService.updateCustomer(param) ? ICarResult.ok() : ICarResult.fail();
    }

    /**
     * 删除客户信息
     */
    @ControllerLog(description = "删除客户信息")
    @PostMapping(ApiPath.CUSTOMER_DELETE)
    public ICarResult deleteCustomer(@Validated(DeleteAction.class) CustomerParam param) {

        return customerService.deleteCustomer(param) ? ICarResult.ok() : ICarResult.fail();
    }

    /**
     * 上年投保信息
     *
     * @param param 查询入参
     * @return 保单数据
     */
    @ControllerLog(description = "查询客户上年投保信息")
    @PostMapping(ApiPath.CUSTOMER_RENEWAL)
    public ICarResult<PolicyInfoVO> queryRenewal(@Validated QueryParam param) {
        Assert.hasText(param.getLicenseNo(), RespInfo.F511.msg);

        return ICarResult.ok(policyService.queryPolicyByLicenseNo(param.getLicenseNo()).orElseGet(PolicyInfoVO::new));
    }
}
