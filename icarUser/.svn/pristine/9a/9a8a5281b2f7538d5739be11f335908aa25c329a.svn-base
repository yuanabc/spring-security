package com.ybinsure.icar.user.controller.policy;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.param.RenewalParam;
import com.ybinsure.icar.user.model.vo.PolicyInfoVO;
import com.ybinsure.icar.user.service.func.RenewalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 续保服务接口
 *
 * @author HANHT
 * @version 2018/7/11 9:39
 */
@RestController
public class RenewalController {

    private static final Logger logger = LoggerFactory.getLogger(RenewalController.class);

    private final RenewalService renewalService;

    @Autowired
    public RenewalController(RenewalService renewalService) {
        this.renewalService = renewalService;
    }

    /**
     * 续保查询
     *
     * @param param 查询入参
     * @return 保单数据
     */
    @ControllerLog(description = "续保查询")
    @PostMapping(ApiPath.POLICY_QUERY_RENEWAL)
    public ICarResult<PolicyInfoVO> queryRenewal(@Validated RenewalParam param) {

        return renewalService.queryRenewal(param).map(ICarResult::ok).orElseGet(ICarResult::noData);
    }
}
