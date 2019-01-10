package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.param.PolicyEncryptParam;
import com.ybinsure.icar.user.model.param.PolicyParam;
import com.ybinsure.icar.user.model.vo.OrderVO;
import com.ybinsure.icar.user.model.vo.PolicyInfoVO;
import com.ybinsure.icar.user.model.vo.QuoteInfoVO;

import java.util.Optional;

/**
 * 保单服务接口
 *
 * @author HANHT
 * @version 2018/7/8 15:52
 */
public interface PolicyService {

    /**
     * 查询保单列表
     *
     * @param param 查询条件
     * @return 分页查询结果
     */
    Optional<PageInfo<OrderVO>> queryUserPolicy(QueryParam param);

    /**
     * 查询保单信息
     *
     * @param param 查询条件
     * @return 保单信息
     */
    Optional<PolicyInfoVO> queryPolicy(PolicyParam param);

    /**
     * 查询保单信息-分享链接查询
     *
     * @param param 查询条件
     * @return 保单信息
     */
    Optional<PolicyInfoVO> queryPolicyWithoutAuthorization(PolicyEncryptParam param);

    /**
     * 最近询价数据列表
     *
     * @param param 查询条件
     * @return 查询结果
     */
    Optional<PageInfo<QuoteInfoVO>> queryRecentQuoteRecord(QueryParam param);

    /**
     * 根据车架号查询最近询价数据列表
     *
     * @param param 查询条件
     * @return 查询结果
     */
    Optional<PageInfo<QuoteInfoVO>> queryRecentQuoteRecordByFrameNo(QueryParam param);

    /**
     * 查询保单车辆信息
     *
     * @param param 查询条件
     * @return 车辆信息
     */
    Optional<PolicyInfoVO> queryPolicyVehicle(QueryParam param);

    /**
     * 根据车牌号查询已承保的保单信息
     *
     * @param licenseNo 车牌号
     * @return 保单信息
     */
    Optional<PolicyInfoVO> queryPolicyByLicenseNo(String licenseNo);

    /**
     * 根据车牌号查询报价成功的保单信息
     *
     * @param licenseNo 车牌号
     * @return 保单信息
     */
    Optional<PolicyInfoVO> queryPolicyByLicenseNoUnderwrite(String licenseNo);

    /**
     * 删除保单
     *
     * @param param 条件
     * @return 结果
     */
    boolean deletePolicy(PolicyParam param);
}
