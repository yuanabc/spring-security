package com.ybinsure.icar.user.model.vo;

import com.ybinsure.icar.user.model.data.PolicyApplicantDO;
import com.ybinsure.icar.user.util.JsonUtil;

import java.util.List;

/**
 * 保单详情结果对象
 *
 * @author HANHT
 * @version 2018/7/8 20:05
 */
public class PolicyInfoVO {

    /** 保单信息 */
    private PolicyVO policy;
    /** 车辆信息 */
    private PolicyVehicleVO vehicle;
    /** 关系人信息 */
    private PolicyApplicantDO applicant;
    /** 险种信息 */
    private List<PolicyRiskVO> risks;
    /** 上传资料列表 */
    private List<FileVO> images;

    /** 续保查询接口返回是否需要填写身份证后几位 */
    private Byte isInput;

    /** 订单分享加密信息 */
    private String shareId;

    /** 续保险种信息 */
    private List<PolicyRiskVO> renewalRisks;

    /** 投保地-省编码 */
    private String insureProvince;
    /** 投保地-市编码 */
    private String insureCity;

    public PolicyInfoVO() {
    }

    public PolicyInfoVO(Byte isInput) {
        this.isInput = isInput;
    }

    public PolicyVO getPolicy() {
        return policy;
    }

    public void setPolicy(PolicyVO policy) {
        this.policy = policy;
    }

    public PolicyVehicleVO getVehicle() {
        return vehicle;
    }

    public void setVehicle(PolicyVehicleVO vehicle) {
        this.vehicle = vehicle;
    }

    public PolicyApplicantDO getApplicant() {
        return applicant;
    }

    public void setApplicant(PolicyApplicantDO applicant) {
        this.applicant = applicant;
    }

    public List<PolicyRiskVO> getRisks() {
        return risks;
    }

    public void setRisks(List<PolicyRiskVO> risks) {
        this.risks = risks;
    }

    public List<FileVO> getImages() {
        return images;
    }

    public void setImages(List<FileVO> images) {
        this.images = images;
    }

    public Byte getIsInput() {
        return isInput;
    }

    public void setIsInput(Byte isInput) {
        this.isInput = isInput;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public List<PolicyRiskVO> getRenewalRisks() {
        return renewalRisks;
    }

    public void setRenewalRisks(List<PolicyRiskVO> renewalRisks) {
        this.renewalRisks = renewalRisks;
    }

    public String getInsureProvince() {
        return insureProvince;
    }

    public void setInsureProvince(String insureProvince) {
        this.insureProvince = insureProvince;
    }

    public String getInsureCity() {
        return insureCity;
    }

    public void setInsureCity(String insureCity) {
        this.insureCity = insureCity;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
