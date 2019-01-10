package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ybinsure.icar.user.config.CustomDoubleSerialize;
import com.ybinsure.icar.user.util.JsonUtil;

import java.util.Date;

/**
 * 保单结果对象
 *
 * @author HANHT
 * @version 2018/7/8 20:12
 */
public class PolicyVO {

    /** 原ic_order表orderid */
    private String orderId;

    /** 保单业务员ID */
    private String userId;

    /** 投保保险公司id */
    private Byte companyId;

    /** 投保保险公司名称 */
    private String companyName;

    /** 交强险起保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciStartDate;

    /** 交强险终保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciEndDate;

    /** 商业险起保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciStartDate;

    /** 商业险终保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciEndDate;

    /** 总保费 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double totalPremium;

    /** 交强险保费 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double tciPremium;

    /** 商业险保费 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double vciPremium;

    /** 车船税 */
    private Double vehicleTax;

    /** 交强险出险次数 */
    private Byte tciLossOccurredCount;

    /** 商业险出险次数 */
    private Byte vciLossOccurredCount;

    /** 交强险折扣 */
    private Double tciDiscount;

    /** 商业险折扣 */
    private Double vciDiscount;

    /** 交强险佣金 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double tciCommission;

    /** 商业险佣金 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double vciCommission;

    /** 电子保单收件人姓名 */
    private String receiveName;

    /** 电子保单收件人地址 */
    private String receiveAddress;

    /** 电子保单收件人电话 */
    private String receivePhone;

    /** 投保单号 */
    private String proposalNo;

    /** 交强险投保单号 */
    private String tciProposalNo;

    /** 商业险投保单号 */
    private String vciProposalNo;

    /** 支付号 */
    private String payNo;

    /** 综合保单号 */
    private String policyNo;

    /** 交强险保单号 */
    private String tciPolicyNo;

    /** 商业险保单号 */
    private String vciPolicyNo;

    /** 交强险保单状态：0待审核/1审核通过/2下发修改 */
    private Byte tciPolicyStatus;

    /** 交强险保单状态描述 */
    private String tciStatusMessage;

    /** 商业险保单状态：0待审核/1审核通过/2下发修改 */
    private Byte vciPolicyStatus;

    /** 商业险保单状态描述 */
    private String vciStatusMessage;

    /** 保单状态 0未支付/1已支付，生成保单成功/2支付失败/3已支付，生成保单失败/4已支付，保单生成中 */
    private Byte policyStatus;

    /** 报价失败原因/核保失败原因/同步失败原因 */
    private String reason;

    /** 报价时间 */
    private Long quoteTime;

    /** 投保时间 */
    private Long insureTime;

    /** 支付时间 */
    private Long payTime;

    /** 生成保单时间 */
    private Long policyTime;

    /** 交强险续保到期日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciPolicyEndDate;

    /** 商业险续保到期日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciPolicyEndDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getTciStartDate() {
        return tciStartDate;
    }

    public void setTciStartDate(Date tciStartDate) {
        this.tciStartDate = tciStartDate;
    }

    public Date getTciEndDate() {
        return tciEndDate;
    }

    public void setTciEndDate(Date tciEndDate) {
        this.tciEndDate = tciEndDate;
    }

    public Date getVciStartDate() {
        return vciStartDate;
    }

    public void setVciStartDate(Date vciStartDate) {
        this.vciStartDate = vciStartDate;
    }

    public Date getVciEndDate() {
        return vciEndDate;
    }

    public void setVciEndDate(Date vciEndDate) {
        this.vciEndDate = vciEndDate;
    }

    public Double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public Double getTciPremium() {
        return tciPremium;
    }

    public void setTciPremium(Double tciPremium) {
        this.tciPremium = tciPremium;
    }

    public Double getVciPremium() {
        return vciPremium;
    }

    public void setVciPremium(Double vciPremium) {
        this.vciPremium = vciPremium;
    }

    public Double getVehicleTax() {
        return vehicleTax;
    }

    public void setVehicleTax(Double vehicleTax) {
        this.vehicleTax = vehicleTax;
    }

    public Byte getTciLossOccurredCount() {
        return tciLossOccurredCount;
    }

    public void setTciLossOccurredCount(Byte tciLossOccurredCount) {
        this.tciLossOccurredCount = tciLossOccurredCount;
    }

    public Byte getVciLossOccurredCount() {
        return vciLossOccurredCount;
    }

    public void setVciLossOccurredCount(Byte vciLossOccurredCount) {
        this.vciLossOccurredCount = vciLossOccurredCount;
    }

    public Double getTciDiscount() {
        return tciDiscount;
    }

    public void setTciDiscount(Double tciDiscount) {
        this.tciDiscount = tciDiscount;
    }

    public Double getVciDiscount() {
        return vciDiscount;
    }

    public void setVciDiscount(Double vciDiscount) {
        this.vciDiscount = vciDiscount;
    }

    public Double getTciCommission() {
        return tciCommission;
    }

    public void setTciCommission(Double tciCommission) {
        this.tciCommission = tciCommission;
    }

    public Double getVciCommission() {
        return vciCommission;
    }

    public void setVciCommission(Double vciCommission) {
        this.vciCommission = vciCommission;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getTciProposalNo() {
        return tciProposalNo;
    }

    public void setTciProposalNo(String tciProposalNo) {
        this.tciProposalNo = tciProposalNo;
    }

    public String getVciProposalNo() {
        return vciProposalNo;
    }

    public void setVciProposalNo(String vciProposalNo) {
        this.vciProposalNo = vciProposalNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getTciPolicyNo() {
        return tciPolicyNo;
    }

    public void setTciPolicyNo(String tciPolicyNo) {
        this.tciPolicyNo = tciPolicyNo;
    }

    public String getVciPolicyNo() {
        return vciPolicyNo;
    }

    public void setVciPolicyNo(String vciPolicyNo) {
        this.vciPolicyNo = vciPolicyNo;
    }

    public Byte getTciPolicyStatus() {
        return tciPolicyStatus;
    }

    public void setTciPolicyStatus(Byte tciPolicyStatus) {
        this.tciPolicyStatus = tciPolicyStatus;
    }

    public String getTciStatusMessage() {
        return tciStatusMessage;
    }

    public void setTciStatusMessage(String tciStatusMessage) {
        this.tciStatusMessage = tciStatusMessage;
    }

    public Byte getVciPolicyStatus() {
        return vciPolicyStatus;
    }

    public void setVciPolicyStatus(Byte vciPolicyStatus) {
        this.vciPolicyStatus = vciPolicyStatus;
    }

    public String getVciStatusMessage() {
        return vciStatusMessage;
    }

    public void setVciStatusMessage(String vciStatusMessage) {
        this.vciStatusMessage = vciStatusMessage;
    }

    public Byte getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(Byte policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(Long quoteTime) {
        this.quoteTime = quoteTime;
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

    public Date getTciPolicyEndDate() {
        return tciPolicyEndDate;
    }

    public void setTciPolicyEndDate(Date tciPolicyEndDate) {
        this.tciPolicyEndDate = tciPolicyEndDate;
    }

    public Date getVciPolicyEndDate() {
        return vciPolicyEndDate;
    }

    public void setVciPolicyEndDate(Date vciPolicyEndDate) {
        this.vciPolicyEndDate = vciPolicyEndDate;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
