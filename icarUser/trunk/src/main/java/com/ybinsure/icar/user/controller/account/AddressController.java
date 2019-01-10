package com.ybinsure.icar.user.controller.account;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.annotation.DeleteAction;
import com.ybinsure.icar.user.annotation.InsertAction;
import com.ybinsure.icar.user.annotation.UpdateAction;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.param.AddressParam;
import com.ybinsure.icar.user.model.vo.AddressVO;
import com.ybinsure.icar.user.service.data.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收件地址管理接口
 *
 * @author HANHT
 * @version 2018/6/13 11:37
 */
@RestController
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * 保单配送地址查询
     */
    @ControllerLog(description = "保单配送地址查询")
    @PostMapping(ApiPath.ADDRESS_LIST)
    public ICarResult<PageInfo<AddressVO>> listAddr(PageInfo param) {

        return ICarResult.ok(addressService.queryAddressByUser(param).orElseGet(PageInfo::new));
    }

    /**
     * 添加保单配送地址
     */
    @ControllerLog(description = "添加保单配送地址")
    @PostMapping(ApiPath.ADDRESS_ADD)
    public ICarResult addAddr(@Validated(InsertAction.class) AddressParam param) {

        return addressService.addAddress(param) ? ICarResult.ok() : ICarResult.fail();
    }

    /**
     * 修改保单配送地址
     */
    @ControllerLog(description = "修改保单配送地址")
    @PostMapping(ApiPath.ADDRESS_UPDATE)
    public ICarResult updateAddr(@Validated(UpdateAction.class) AddressParam param) {

        return addressService.updateAddress(param) ? ICarResult.ok() : ICarResult.fail();
    }

    /**
     * 删除保单配送地址
     */
    @ControllerLog(description = "删除保单配送地址")
    @PostMapping(ApiPath.ADDRESS_DELETE)
    public ICarResult deleteAddr(@Validated(DeleteAction.class) AddressParam param) {

        return addressService.deleteAddress(param) ? ICarResult.ok() : ICarResult.fail();
    }
}
