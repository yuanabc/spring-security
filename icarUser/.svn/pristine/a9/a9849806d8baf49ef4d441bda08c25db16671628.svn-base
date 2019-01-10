package com.ybinsure.icar.user.controller.policy;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.param.PolicyEncryptParam;
import com.ybinsure.icar.user.model.param.PolicyParam;
import com.ybinsure.icar.user.model.vo.OrderVO;
import com.ybinsure.icar.user.model.vo.PolicyInfoVO;
import com.ybinsure.icar.user.model.vo.QuoteInfoVO;
import com.ybinsure.icar.user.service.data.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 保单服务接口
 *
 * @author HANHT
 * @version 2018/7/8 15:51
 */
@RestController
public class PolicyController {

    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    /**
     * 保单列表
     *
     * @param param 查询条件
     * @return 列表数据
     */
    @ControllerLog(description = "保单列表")
    @PostMapping(ApiPath.POLICY_LIST)
    public ICarResult<PageInfo<OrderVO>> listPolicy(@Validated QueryParam param) {

        return ICarResult.ok(policyService.queryUserPolicy(param).orElseGet(PageInfo::new));
    }

    /**
     * 查询订单详情
     *
     * @param param 查询条件
     * @return 订单详情
     */
    @ControllerLog(description = "查询订单详情")
    @PostMapping(ApiPath.POLICY_QUERY)
    public ICarResult<PolicyInfoVO> queryPolicy(@Validated PolicyParam param) {

        return policyService.queryPolicy(param).map(ICarResult::ok).orElseGet(ICarResult::noData);
    }

    /**
     * 分享链接查询订单详情
     *
     * @param param 查询条件
     * @return 订单详情
     */
    @ControllerLog(description = "分享链接查询订单详情")
    @PostMapping(ApiPath.POLICY_QUERY_AVOID_LOGIN)
    public ICarResult<PolicyInfoVO> queryPolicyWithoutAuthorization(@Validated PolicyEncryptParam param) {

        return policyService.queryPolicyWithoutAuthorization(param).map(ICarResult::ok).orElseGet(ICarResult::noData);
    }

    /**
     * 查询最近报价列表
     *
     * @param param 查询条件
     * @return 报价列表
     */
    @ControllerLog(description = "查询最近报价列表")
    @PostMapping(ApiPath.POLICY_RECENT_QUOTE)
    public ICarResult<PageInfo<QuoteInfoVO>> recentQuote(@Validated QueryParam param) {

        return ICarResult.ok(policyService.queryRecentQuoteRecord(param).orElseGet(PageInfo::new));
    }

    /**
     * 根据车架号查询最近报价列表
     *
     * @param param 查询条件
     * @return 报价列表
     */
    @ControllerLog(description = "根据车架号查询最近报价列表")
    @PostMapping(ApiPath.POLICY_RECENT_QUOTE_BY_FRAME_NO)
    public ICarResult<PageInfo<QuoteInfoVO>> recentQuoteByFrameNo(@Validated QueryParam param) {
        Assert.hasText(param.getFrameNo(), "车架号不能为空");

        return ICarResult.ok(policyService.queryRecentQuoteRecordByFrameNo(param).orElseGet(PageInfo::new));
    }

    /**
     * 查询保单车辆信息
     *
     * @param param 查询条件
     * @return 车辆信息
     */
    @ControllerLog(description = "查询保单车辆信息")
    @PostMapping(ApiPath.POLICY_QUERY_VEHICLE)
    public ICarResult<PolicyInfoVO> getVehicle(@Validated QueryParam param) {
        Assert.hasText(param.getLicenseNo(), "车牌号不能为空");

        return ICarResult.ok(policyService.queryPolicyVehicle(param).orElseGet(PolicyInfoVO::new));
    }

    /**
     * 删除保单
     *
     * @param param 条件
     * @return 结果
     */
    @ControllerLog(description = "删除保单")
    @PostMapping(ApiPath.POLICY_DELETE)
    public ICarResult deletePolicy(@Validated PolicyParam param) {

        return policyService.deletePolicy(param) ? ICarResult.ok() : ICarResult.fail();
    }
}
