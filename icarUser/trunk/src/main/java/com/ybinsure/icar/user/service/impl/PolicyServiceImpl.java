package com.ybinsure.icar.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.icar.user.auth.AuthenticationHelper;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.constant.SourceType;
import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.mapper.extend.PolicyExtendMapper;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.data.PolicyApplicantDO;
import com.ybinsure.icar.user.model.data.PolicyDO;
import com.ybinsure.icar.user.model.data.PolicyDOExample;
import com.ybinsure.icar.user.model.data.PolicyVehicleDO;
import com.ybinsure.icar.user.model.dto.InsureInfoDTO;
import com.ybinsure.icar.user.model.dto.OrderDTO;
import com.ybinsure.icar.user.model.dto.PolicyInfoDTO;
import com.ybinsure.icar.user.model.param.PolicyEncryptParam;
import com.ybinsure.icar.user.model.param.PolicyParam;
import com.ybinsure.icar.user.model.vo.OrderVO;
import com.ybinsure.icar.user.model.vo.PolicyInfoVO;
import com.ybinsure.icar.user.model.vo.PolicyVO;
import com.ybinsure.icar.user.model.vo.PolicyVehicleVO;
import com.ybinsure.icar.user.model.vo.QuoteInfoVO;
import com.ybinsure.icar.user.service.data.FileService;
import com.ybinsure.icar.user.service.data.PolicyRiskService;
import com.ybinsure.icar.user.service.data.PolicyService;
import com.ybinsure.icar.user.util.RSAUtil;
import com.ybinsure.icar.user.util.SourceUtil;
import com.ybinsure.icar.user.util.StrUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 保单服务接口实现
 *
 * @author HANHT
 * @version 2018/7/8 15:52
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyExtendMapper policyExtendMapper;
    private final PolicyRiskService policyRiskService;
    private final FileService fileService;

    @Autowired
    public PolicyServiceImpl(PolicyExtendMapper policyExtendMapper, PolicyRiskService policyRiskService, FileService fileService) {
        this.policyExtendMapper = policyExtendMapper;
        this.policyRiskService = policyRiskService;
        this.fileService = fileService;
    }

    @Override
    public Optional<PageInfo<OrderVO>> queryUserPolicy(QueryParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());

        Page<OrderDTO> pages;
        if (SourceType.LIKE_CG == SourceUtil.matchType(AuthenticationHelper.getChannelCode().orElse(""))) {
            pages = policyExtendMapper.selectUserPolicyByCG(param);
        } else {
            pages = policyExtendMapper.selectUserPolicy(param);
        }
        if (pages.getTotal() == 0) {

            return Optional.empty();
        }

        List<OrderDTO> list = pages.getResult();

        List<OrderVO> result = new ArrayList<>();
        list.forEach(o -> {
            OrderVO vo = new OrderVO();
            result.add(vo);
            // 赋值相同字段
            BeanUtils.copyProperties(o, vo);
            // 保单状态
            Byte status = o.getPolicyStatus();
            Long orderTime;
            if (status > 6) {
                orderTime = o.getPolicyTime();
            } else if (status > 4) {
                orderTime = o.getPayTime();
            } else {
                orderTime = o.getInsureTime();
            }
            vo.setOrderTime(orderTime);
        });

        PageInfo<OrderVO> pageResult = new PageInfo<>();
        BeanUtils.copyProperties(pages, pageResult);

        pageResult.setList(result);

        return Optional.of(pageResult);
    }

    @Override
    public Optional<PolicyInfoVO> queryPolicy(PolicyParam param) {
        // 查询订单信息
        PolicyInfoVO vo;
        if (SourceType.LIKE_CG == SourceUtil.matchType(AuthenticationHelper.getChannelCode().orElse(""))) {
            if (policyExtendMapper.countPolicyByCG(param.getOrderId(), param.getAuth()) <= 0) {

                return Optional.empty();
            }
            vo = queryPolicy(param.getOrderId(), null);
        } else {
            vo = queryPolicy(param.getOrderId(), param.getAuth());
        }

        // 订单号加密信息
        String shareId = RSAUtil.encryptByPublicKey(param.getOrderId());
        vo.setShareId(shareId);

        return Optional.of(vo);
    }

    @Override
    public Optional<PolicyInfoVO> queryPolicyWithoutAuthorization(PolicyEncryptParam param) {
        Assert.hasText(param.getOrderId(), RespInfo.F511.msg);
        // 查询订单信息，orderId为加密串，不需要用户id
        PolicyInfoVO vo = queryPolicy(param.getOrderId(), null);
        // 分享链接不返回orderId
        PolicyVO policy = vo.getPolicy();
        policy.setOrderId(null);

        return Optional.of(vo);
    }

    @Override
    public Optional<PageInfo<QuoteInfoVO>> queryRecentQuoteRecord(QueryParam param) {
        // 查询结果
        List<QuoteInfoVO> result;
        if (SourceType.LIKE_CG == SourceUtil.matchType(AuthenticationHelper.getChannelCode().orElse(""))) {
            result = policyExtendMapper.selectRecentQuoteByCG(param);
        } else {
            result = policyExtendMapper.selectRecentQuote(param);
        }
        if (CollectionUtils.isEmpty(result)) {

            return Optional.empty();
        }

        // 转义是否成功字段
        result.forEach(o -> o.setIsSuccess(o.getPolicyStatus() > 0 ? SwitchCode.ENABLE : SwitchCode.DISABLE));

        return Optional.of(new PageInfo<>(result));
    }

    @Override
    public Optional<PageInfo<QuoteInfoVO>> queryRecentQuoteRecordByFrameNo(QueryParam param) {
        Assert.hasText(param.getFrameNo(), "车架号不能为空");

        // 查询结果
        List<QuoteInfoVO> result;
        if (SourceType.LIKE_CG == SourceUtil.matchType(AuthenticationHelper.getChannelCode().orElse(""))) {
            result = policyExtendMapper.selectRecentQuoteByFrameNoByCG(param);
        } else {
            result = policyExtendMapper.selectRecentQuoteByFrameNo(param);
        }
        if (CollectionUtils.isEmpty(result)) {

            return Optional.empty();
        }

        // 转义是否成功字段
        result.forEach(o -> o.setIsSuccess(o.getPolicyStatus() > 0 ? SwitchCode.ENABLE : SwitchCode.DISABLE));

        return Optional.of(new PageInfo<>(result));
    }

    @Override
    public Optional<PolicyInfoVO> queryPolicyVehicle(QueryParam param) {
        // 查询保单车辆信息
        PolicyVehicleDO vehicleDO = policyExtendMapper.selectPolicyVehicle(param);
        if (vehicleDO == null) {

            return Optional.empty();
        }

        PolicyVehicleVO vo = new PolicyVehicleVO();
        BeanUtils.copyProperties(vehicleDO, vo);

        // 组装返回对象
        PolicyInfoVO policyInfo = new PolicyInfoVO();
        policyInfo.setVehicle(vo);

        return Optional.of(policyInfo);
    }

    @Override
    public Optional<PolicyInfoVO> queryPolicyByLicenseNo(String licenseNo) {
        Assert.hasText(licenseNo, RespInfo.ERROR.msg);

        // 查询订单信息
        PolicyInfoDTO dto = policyExtendMapper.selectPolicyByLicenseNo(licenseNo);
        if (dto == null) {

            return Optional.empty();
        }

        return Optional.of(convertResult(dto));
    }

    @Override
    public Optional<PolicyInfoVO> queryPolicyByLicenseNoUnderwrite(String licenseNo) {
        Assert.hasText(licenseNo, RespInfo.ERROR.msg);

        // 查询订单信息
        PolicyInfoDTO dto = policyExtendMapper.selectPolicyByLicenseNoUnderwrite(licenseNo);
        if (dto == null) {

            return Optional.empty();
        }

        return Optional.of(convertResult(dto));
    }

    @Override
    public boolean deletePolicy(PolicyParam param) {
        Assert.hasText(param.getOrderId(), RespInfo.ERROR.msg);
        Assert.hasText(param.getAuth(), RespInfo.ERROR.msg);

        PolicyDOExample example = new PolicyDOExample();
        example.or().andOrderIdEqualTo(param.getOrderId()).andUserIdEqualTo(param.getAuth());

        PolicyDO policyDO = new PolicyDO();
        // 是否删除：0未删/1已删
        policyDO.setIsDeleted(SwitchCode.ENABLE);

        return policyExtendMapper.updateByExampleSelective(policyDO, example) > 0;
    }

    /**
     * 根据订单号查询保单数据
     *
     * @param orderId 订单号
     * @param userId  用户id
     * @return 保单数据
     */
    private PolicyInfoVO queryPolicy(String orderId, String userId) {
        // 查询订单信息
        PolicyInfoDTO dto = policyExtendMapper.selectPolicyInfo(orderId, userId);
        Assert.notNull(dto, RespInfo.F513.msg);

        PolicyInfoVO vo = convertResult(dto);
        // 查询影像资料数据
        vo.setImages(fileService.queryPolicyImages(dto.getOrderId()).orElseGet(ArrayList::new));

        // 查询保单投保地
        convertInsureArea(dto, vo);

        return vo;
    }

    /**
     * 转化保单结果
     *
     * @param dto 保单查询结果
     * @return 保单结果
     */
    private PolicyInfoVO convertResult(PolicyInfoDTO dto) {
        PolicyVO policyVO = new PolicyVO();
        BeanUtils.copyProperties(dto, policyVO);
        // 车辆信息
        PolicyVehicleVO vehicleVO = new PolicyVehicleVO();
        BeanUtils.copyProperties(dto, vehicleVO);
        // 人员信息
        PolicyApplicantDO applicantDO = new PolicyApplicantDO();
        BeanUtils.copyProperties(dto, applicantDO);

        // 组装返回对象
        PolicyInfoVO vo = new PolicyInfoVO();
        vo.setPolicy(policyVO);
        vo.setVehicle(vehicleVO);
        vo.setApplicant(applicantDO);
        vo.setRisks(policyRiskService.queryRisks(dto.getPolicyId()).orElseGet(ArrayList::new));

        return vo;
    }

    /**
     * 查询投保地
     */
    private void convertInsureArea(PolicyInfoDTO dto, PolicyInfoVO vo) {
        String policyChannelId;
        if (StrUtil.isNotBlank(dto.getChannel6())) {
            policyChannelId = dto.getChannel6();
        } else if (StrUtil.isNotBlank(dto.getChannel5())) {
            policyChannelId = dto.getChannel5();
        } else if (StrUtil.isNotBlank(dto.getChannel4())) {
            policyChannelId = dto.getChannel4();
        } else if (StrUtil.isNotBlank(dto.getChannel3())) {
            policyChannelId = dto.getChannel3();
        } else if (StrUtil.isNotBlank(dto.getChannel2())) {
            policyChannelId = dto.getChannel2();
        } else if (StrUtil.isNotBlank(dto.getChannel1())) {
            policyChannelId = dto.getChannel1();
        } else {
            policyChannelId = dto.getChannel0();
        }
        if (StrUtil.isBlank(policyChannelId)) {

            return;
        }

        InsureInfoDTO insureInfoDTO = policyExtendMapper.selectPolicyInsureArea(policyChannelId);
        if (insureInfoDTO == null) {

            return;
        }

        vo.setInsureProvince(insureInfoDTO.getInsureProvince());
        vo.setInsureCity(insureInfoDTO.getInsureCity());
    }
}
