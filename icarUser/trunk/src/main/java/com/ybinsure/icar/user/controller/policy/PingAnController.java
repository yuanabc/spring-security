package com.ybinsure.icar.user.controller.policy;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.vo.OrderVO;
import com.ybinsure.icar.user.service.data.PingAnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 云南平安订单管理
 *
 * @author HANHT
 * @version 2018/7/15 12:40
 */
@RestController
public class PingAnController {

    private static final Logger logger = LoggerFactory.getLogger(PingAnController.class);

    private final PingAnService pingAnService;

    @Autowired
    public PingAnController(PingAnService pingAnService) {
        this.pingAnService = pingAnService;
    }

    /**
     * 云南订单列表
     *
     * @param param 查询条件
     * @return 列表数据
     */
    @ControllerLog(description = "平安订单列表")
    @PostMapping(ApiPath.POLICY_PING_AN_ORDER)
    public ICarResult<PageInfo<OrderVO>> listOrder(@Validated QueryParam param) {

        return ICarResult.ok(pingAnService.queryUserOrder(param).orElseGet(PageInfo::new));
    }
}
