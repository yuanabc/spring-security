package com.ybinsure.icar.user.model.dto;

import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 订单列表查询传输对象
 *
 * @author HANHT
 * @version 2018/7/8 16:07
 */
public class OrderDTO {

    /** 订单编号 */
    private String orderId;
    /** 投保时间 */
    private Long insureTime;
    /** 支付时间 */
    private Long payTime;
    /** 生成保单时间 */
    private Long policyTime;
    /** 保险公司id */
    private Byte companyId;
    /** 保险公司名称 */
    private String companyName;
    /** 总保费 */
    private Double totalPremium;
    /** 交强险保单状态：0待审核/1审核通过/2下发修改 */
    private Byte tciPolicyStatus;
    /** 商业险保单状态：0待审核/1审核通过/2下发修改 */
    private Byte vciPolicyStatus;
    /** 保单状态 0未支付/1已支付，生成保单成功/2支付失败/3已支付，生成保单失败/4已支付，保单生成中 */
    private Byte policyStatus;
    /** 车牌号 */
    private String licenseNo;
    /** 车主名称 */
    private String ownerName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getInsureTime() {
        return insureTime;
    }

    public void setInsureTime(Long insureTime) {
        this.insureTime = insureTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getPolicyTime() {
        return policyTime;
    }

    public void setPolicyTime(Long policyTime) {
        this.policyTime = policyTime;
    }

    public Byte getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Byte companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public Byte getTciPolicyStatus() {
        return tciPolicyStatus;
    }

    public void setTciPolicyStatus(Byte tciPolicyStatus) {
        this.tciPolicyStatus = tciPolicyStatus;
    }

    public Byte getVciPolicyStatus() {
        return vciPolicyStatus;
    }

    public void setVciPolicyStatus(Byte vciPolicyStatus) {
        this.vciPolicyStatus = vciPolicyStatus;
    }

    public Byte getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(Byte policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
