package com.ybinsure.icar.user.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.ybinsure.icar.user.constant.ConfigConst;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.constant.RiskInfo;
import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.model.data.IcarChannelDO;
import com.ybinsure.icar.user.model.data.PolicyApplicantDO;
import com.ybinsure.icar.user.model.dto.IcarChannelDTO;
import com.ybinsure.icar.user.model.dto.RenewalQueryDTO;
import com.ybinsure.icar.user.model.param.RenewalParam;
import com.ybinsure.icar.user.model.vo.PolicyInfoVO;
import com.ybinsure.icar.user.model.vo.PolicyRiskVO;
import com.ybinsure.icar.user.model.vo.PolicyVO;
import com.ybinsure.icar.user.model.vo.PolicyVehicleVO;
import com.ybinsure.icar.user.service.data.IcarChannelService;
import com.ybinsure.icar.user.service.data.PolicyService;
import com.ybinsure.icar.user.service.func.RenewalService;
import com.ybinsure.icar.user.util.AreaUtil;
import com.ybinsure.icar.user.util.BeanUtil;
import com.ybinsure.icar.user.util.DateUtil;
import com.ybinsure.icar.user.util.HttpUtil;
import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 续保查询功能服务实现
 *
 * @author HANHT
 * @version 2018/7/11 11:23
 */
@Service
public class RenewalServiceImpl implements RenewalService {

    private static final Logger logger = LoggerFactory.getLogger(RenewalServiceImpl.class);

    private final PolicyService policyService;
    private final IcarChannelService channelService;

    @Autowired
    public RenewalServiceImpl(PolicyService policyService, IcarChannelService channelService) {
        this.policyService = policyService;
        this.channelService = channelService;
    }

    @Override
    public Optional<PolicyInfoVO> queryLocalRenewal(RenewalParam param) {
        // 查询本地已承保保单数据
        return policyService.queryPolicyByLicenseNo(param.getLicenseNo());
    }

    @Override
    public Optional<PolicyInfoVO> queryRenewal(RenewalParam param) {
        // 查询本地已承保保单数据
        Optional<PolicyInfoVO> policyInfoVOOptional = policyService.queryPolicyByLicenseNo(param.getLicenseNo());
        if (policyInfoVOOptional.isPresent()) {
            // 续保到期日期加1天
            policyEndDatePlusOneDay(policyInfoVOOptional.get());

            return policyInfoVOOptional;
        }

        // 查询工号数据
        Optional<Set<IcarChannelDO>> channelsOpt = queryChannel(param);
        if (!channelsOpt.isPresent() || CollectionUtils.isEmpty(channelsOpt.get())) {

            return Optional.empty();
        }

        // 工号转化成入参json
        Optional<String> jsonOpt = JsonUtil.toJson(channelsOpt.get());
        if (!jsonOpt.isPresent()) {

            return Optional.empty();
        }

        StringBuilder params = new StringBuilder();
        params.append("carLicense=").append(param.getLicenseNo());
        if (StrUtil.isNotBlank(param.getCardLastNo())) {
            params.append("&card6=").append(param.getCardLastNo());
        }
        params.append("&jsonArr=").append(jsonOpt.get());

        // 查询核心续保服务
        logger.info("核心续保服务入参：{}", params.toString());
        String result = HttpUtil.postForm(ConfigConst.MAIN_URL + "j18", params.toString());
        logger.info("核心续保服务返回：{}", result);
        // 查询结果转化成json对象
        Optional<JsonNode> jsonNodeOpt = JsonUtil.readJson(result);
        if (!jsonNodeOpt.isPresent()) {

            return Optional.empty();
        }

        JsonNode json = jsonNodeOpt.get();
        final String error = "e";
        if (json.hasNonNull(error)) {
            Optional<IcarChannelDO> channelOpt = channelService.queryPingAnChannel(param.getAuth());
            Assert.state(channelOpt.isPresent(), json.path(error).asText());

            // 返回需要填写身份证
            return Optional.of(new PolicyInfoVO(SwitchCode.ENABLE));
        }

        final String success = "r";
        if (!json.hasNonNull(success)) {

            return Optional.empty();
        }

        String res = json.path(success).toString();
        Optional<RenewalQueryDTO> renewalOpt = JsonUtil.toPojo(res, RenewalQueryDTO.class);

        // 转化订单数据结果
        Optional<PolicyInfoVO> resOpt = renewalOpt.map(this::convertPolicyInfo);

        // 查询本地报价成功的数据
        policyInfoVOOptional = policyService.queryPolicyByLicenseNoUnderwrite(param.getLicenseNo());
        if (policyInfoVOOptional.isPresent()) {
            if (resOpt.isPresent()) {
                PolicyInfoVO policyInfo = policyInfoVOOptional.get();
                PolicyInfoVO renewalPolicyInfo = resOpt.get();

                // 续保险种
                policyInfo.setRenewalRisks(renewalPolicyInfo.getRisks());
                // 赋值续保保费
                policyInfo.setPolicy(renewalPolicyInfo.getPolicy());
                // 续保到期日期加1天
                policyEndDatePlusOneDay(policyInfo);
            }

            return policyInfoVOOptional;
        }

        return resOpt;
    }

    /**
     * 查询工号
     *
     * @param param 入参
     * @return 工号集
     */
    private Optional<Set<IcarChannelDO>> queryChannel(RenewalParam param) {
        // 没有身份证查人保太平洋中华联合工号
        if (StrUtil.isBlank(param.getCardLastNo())) {

            return Optional.ofNullable(queryChannelByArea(param));
        }

        // 查询平安工号
        Optional<IcarChannelDO> channelOpt = channelService.queryPingAnChannel(param.getAuth());
        if (!channelOpt.isPresent()) {

            return Optional.empty();
        }

        Set<IcarChannelDO> result = new HashSet<>();
        result.add(channelOpt.get());

        return Optional.of(result);
    }

    /**
     * 根据车牌号查询工号
     *
     * @param param 查询入参
     * @return 工号集
     */
    private Set<IcarChannelDO> queryChannelByArea(RenewalParam param) {
        Set<IcarChannelDO> result = new HashSet<>(16);

        // 车牌号
        String licenseNo = param.getLicenseNo();
        // 通过车牌的来返回area
        String areaCode = AreaUtil.getAreaCode(licenseNo);
        Assert.hasText(areaCode, RespInfo.FAIL.msg);

        // 查询人保/太平洋/中华工号
        Optional<Set<IcarChannelDO>> channelOpt = channelService.queryRenewalChannel(new IcarChannelDTO(areaCode, SwitchCode.ENABLE));
        channelOpt.ifPresent(o -> result.addAll(channelOpt.get()));

        // 特殊地区编码 大连/厦门/青岛/深圳
        String specialArea = AreaUtil.getSpecialAreaCode(licenseNo);
        if (StrUtil.isNotBlank(specialArea)) {
            Optional<Set<IcarChannelDO>> specialChannelOpt = channelService.queryRenewalChannel(new IcarChannelDTO(specialArea, SwitchCode.DISABLE));
            specialChannelOpt.ifPresent(o -> result.addAll(specialChannelOpt.get()));
        }

        return result;
    }

    /**
     * 转化续保查询订单数据结果
     *
     * @param dto 续保查询结果
     * @return 订单
     */
    private PolicyInfoVO convertPolicyInfo(RenewalQueryDTO dto) {
        PolicyInfoVO policyInfo = new PolicyInfoVO();
        policyInfo.setPolicy(convertPolicy(dto));
        policyInfo.setVehicle(convertPolicyVehicle(dto));
        policyInfo.setApplicant(convertPolicyApplicant(dto));
        policyInfo.setRisks(convertPolicyRisk(dto));

        return policyInfo;
    }

    /**
     * 转化保单数据
     *
     * @param dto 续保查询结果
     * @return 保单
     */
    private PolicyVO convertPolicy(RenewalQueryDTO dto) {
        PolicyVO policy = new PolicyVO();
        if (StrUtil.isNotBlank(dto.getCompanyId())) {
            policy.setCompanyId(Byte.valueOf(dto.getCompanyId()));
        }
        if (StrUtil.isNotBlank(dto.getPolicyEndForce())) {
            policy.setTciEndDate(DateUtil.toDate(dto.getPolicyEndForce()));
        }
        policy.setTciPolicyNo(dto.getPolicyForce());
        policy.setTciPremium(StrUtil.toDouble(dto.getCostForce(), 0));
        if (StrUtil.isNotBlank(dto.getPolicyEndCom())) {
            policy.setVciEndDate(DateUtil.toDate(dto.getPolicyEndCom()));
        }
        policy.setVciPolicyNo(dto.getPolicyCom());
        policy.setVciPremium(StrUtil.toDouble(dto.getPolicyCom(), 0));

        return policy;
    }

    /**
     * 转化保单车辆数据
     *
     * @param dto 续保查询结果
     * @return 车辆
     */
    private PolicyVehicleVO convertPolicyVehicle(RenewalQueryDTO dto) {
        PolicyVehicleVO vehicle = new PolicyVehicleVO();
        vehicle.setLicenseNo(dto.getCarLicense());
        vehicle.setEngineNo(dto.getCarEngine());
        vehicle.setFrameNo(dto.getCarVin());
        vehicle.setBrandName(dto.getCarName());
        vehicle.setModelCode(dto.getCarCode());
        vehicle.setDisplacement(StrUtil.toDouble(dto.getCarExhaust(), 0));
        vehicle.setPurchasePrice(StrUtil.toInt(dto.getCarPrice(), 0));
        vehicle.setIssueYear(dto.getCarYear());
        vehicle.setCurbWeight(StrUtil.toDouble(dto.getCarQuality(), 0));
        vehicle.setSeatCount(StrUtil.toByte(dto.getCarSeat(), 5));
        vehicle.setEnrollDate(DateUtil.toDate(dto.getCarFirstDate()));
        vehicle.setTransferDate(DateUtil.toDate(dto.getCarTransferDate()));
        vehicle.setUseNature(dto.getUseNature());
        vehicle.setAttachNature(dto.getAttachNature());
        vehicle.setVehicleType(dto.getCarType());
        vehicle.setVehicleCategory(dto.getCarKind());
        vehicle.setPlateType(dto.getPlateType());
        vehicle.setPlateColor(dto.getPlateColor());
        vehicle.setEnergyType(dto.getEnergyType());
        vehicle.setTonnage(StrUtil.toDouble(dto.getTonnage(), 0));

        return vehicle;
    }

    /**
     * 转化保单人员数据
     *
     * @param dto 续保查询结果
     * @return 人员
     */
    private PolicyApplicantDO convertPolicyApplicant(RenewalQueryDTO dto) {
        PolicyApplicantDO applicant = new PolicyApplicantDO();
        applicant.setOwnerIdType(dto.getType1());
        applicant.setOwnerName(dto.getName1());
        applicant.setOwnerIdNo(dto.getCard1());
        applicant.setOwnerAddr(dto.getAddr1());
        applicant.setOwnerPhone(dto.getMobile1());
        applicant.setOwnerBirthday(DateUtil.toDate(dto.getBirthday1()));
        applicant.setOwnerSex(StrUtil.toByte(dto.getSex1(), 1));
        applicant.setOwnerEmail(dto.getEmail());
        applicant.setInsuredIdType(dto.getType2());
        applicant.setInsuredName(dto.getName2());
        applicant.setInsuredIdNo(dto.getCard2());
        applicant.setInsuredAddr(dto.getAddr2());
        applicant.setInsuredPhone(dto.getMobile2());
        applicant.setInsuredBirthday(DateUtil.toDate(dto.getBirthday2()));
        applicant.setInsuredSex(StrUtil.toByte(dto.getSex2(), 1));
        applicant.setHolderIdType(dto.getType3());
        applicant.setHolderName(dto.getName3());
        applicant.setHolderIdNo(dto.getCard3());
        applicant.setHolderAddr(dto.getAddr3());
        applicant.setHolderPhone(dto.getMobile3());
        applicant.setHolderBirthday(DateUtil.toDate(dto.getBirthday3()));
        applicant.setHolderSex(StrUtil.toByte(dto.getSex3(), 1));

        return applicant;
    }

    /**
     * 转化保单险种数据
     *
     * @param dto 续保查询结果
     * @return 险种
     */
    private List<PolicyRiskVO> convertPolicyRisk(RenewalQueryDTO dto) {
        List<PolicyRiskVO> risks = new ArrayList<>(16);

        PolicyRiskVO risk;

        Map<String, Object> riskDTO = BeanUtil.simpleObj2Map(dto);
        // 险种最大a10
        final int maxRisk = 10;
        for (int i = 0; i <= maxRisk; i++) {
            if (StrUtil.isNotNull(riskDTO.get("a" + i))) {
                risk = new PolicyRiskVO();
                risks.add(risk);

                risk.setRiskCode("a" + i);
                risk.setRiskName(RiskInfo.matchName(i));
                risk.setAmount(StrUtil.toDouble(riskDTO.get("c" + i), 0));
                risk.setIsDeductible(StrUtil.isNull(riskDTO.get("b" + i)) ? SwitchCode.DISABLE : SwitchCode.ENABLE);
            }
        }

        return risks;
    }

    /**
     * 保险止期加1天
     *
     * @param policyInfoVO 保单信息
     */
    private void policyEndDatePlusOneDay(PolicyInfoVO policyInfoVO) {
        PolicyVO policyVO = policyInfoVO.getPolicy();
        if (policyVO.getTciEndDate() != null) {
            policyVO.setTciPolicyEndDate(policyVO.getTciEndDate());
            policyVO.setTciStartDate(DateUtil.addDay(policyVO.getTciEndDate(), 1));
        }

        if (policyVO.getVciEndDate() != null) {
            policyVO.setVciPolicyEndDate(policyVO.getVciEndDate());
            policyVO.setVciStartDate(DateUtil.addDay(policyVO.getVciEndDate(), 1));
        }
    }
}
