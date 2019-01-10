package com.ybinsure.icar.user.mapper.extend;

import com.github.pagehelper.Page;
import com.ybinsure.icar.user.mapper.data.PolicyDOMapper;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.data.PolicyVehicleDO;
import com.ybinsure.icar.user.model.dto.InsureInfoDTO;
import com.ybinsure.icar.user.model.dto.OrderDTO;
import com.ybinsure.icar.user.model.dto.PolicyInfoDTO;
import com.ybinsure.icar.user.model.vo.QuoteInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 保单服务扩展
 *
 * @author HANHT
 * @version 2018/7/8 16:01
 */
@Repository
public interface PolicyExtendMapper extends PolicyDOMapper {

    /**
     * 查询保单列表数据
     *
     * @param param 入参对象
     * @return 业绩数据
     */
    Page<OrderDTO> selectUserPolicy(@Param("record") QueryParam param);

    /**
     * 查询保单列表数据
     *
     * @param param 入参对象
     * @return 业绩数据
     */
    Page<OrderDTO> selectUserPolicyByCG(@Param("record") QueryParam param);

    /**
     * 查询保单信息
     *
     * @param orderId 订单号
     * @param userId  用户id
     * @return 保单信息
     */
    PolicyInfoDTO selectPolicyInfo(@Param("orderId") String orderId, @Param("userId") String userId);

    /**
     * 查询最近10条报价记录
     *
     * @param param 查询条件
     * @return 报价记录
     */
    List<QuoteInfoVO> selectRecentQuote(@Param("record") QueryParam param);

    /**
     * 查询最近10条报价记录-灿谷
     *
     * @param param 查询条件
     * @return 报价记录
     */
    List<QuoteInfoVO> selectRecentQuoteByCG(@Param("record") QueryParam param);

    /**
     * 根据车架号查询最近20条报价记录
     *
     * @param param 查询条件
     * @return 报价记录
     */
    List<QuoteInfoVO> selectRecentQuoteByFrameNo(@Param("record") QueryParam param);

    /**
     * 根据车架号查询最近20条报价记录-灿谷
     *
     * @param param 查询条件
     * @return 报价记录
     */
    List<QuoteInfoVO> selectRecentQuoteByFrameNoByCG(@Param("record") QueryParam param);

    /**
     * 客户详情查询车辆信息
     *
     * @param param 查询条件
     * @return 保单车辆信息
     */
    PolicyVehicleDO selectPolicyVehicle(@Param("record") QueryParam param);

    /**
     * 根据车牌号查询已承保的保单信息
     *
     * @param licenseNo 车牌号
     * @return 保单信息
     */
    PolicyInfoDTO selectPolicyByLicenseNo(String licenseNo);

    /**
     * 根据车牌号查询报价成功的保单信息
     *
     * @param licenseNo 车牌号
     * @return 保单信息
     */
    PolicyInfoDTO selectPolicyByLicenseNoUnderwrite(String licenseNo);

    /**
     * 根据保单所属渠道id查找投保地信息
     *
     * @param policyChannelId 保单所属渠道id
     * @return 投保信息
     */
    InsureInfoDTO selectPolicyInsureArea(String policyChannelId);

    /**
     * 校验灿谷类型渠道订单号与用户信息
     *
     * @param orderId 订单号
     * @param userId  用户信息
     * @return 数量
     */
    Integer countPolicyByCG(@Param("orderId") String orderId, @Param("userId") String userId);
}
