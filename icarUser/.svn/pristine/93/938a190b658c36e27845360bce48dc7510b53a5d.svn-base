package com.ybinsure.icar.user.model.data;

import java.io.Serializable;
import java.util.Date;

/**
 * 保单数据
 *
 * @author HANHT
 * @version 2018/7/12 17:31
 */
public class PolicyDO implements Serializable {
    /** 主键UUID */
    private String id;

    /** 原ic_order表orderid */
    private String orderId;

    /** 业务员id */
    private String userId;

    /** 渠道id */
    private String sourceCode;

    /** 投保保险公司id */
    private Byte companyId;

    /** 出单工号id */
    private Integer channelId;

    /** 交强险起保日期 */
    private Date tciStartDate;

    /** 交强险终保日期 */
    private Date tciEndDate;

    /** 商业险起保日期 */
    private Date vciStartDate;

    /** 商业险终保日期 */
    private Date vciEndDate;

    /** 总保费 */
    private Double totalPremium;

    /** 交强险保费 */
    private Double tciPremium;

    /** 商业险保费 */
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
    private Double tciCommission;

    /** 商业险佣金 */
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

    /** 保单状态：0报价失败/1报价成功/2下发修改/3人工审核/4核保成功/5支付失败/6支付成功/7承保失败/8承保成功 */
    private Byte policyStatus;

    /** 协议编码，对接核心系统的保险公司代码 */
    private String protocolCode;

    /** 出单员id */
    private String operatorId;

    /** 业务性质 01 个人代理 02 合作渠道 */
    private String businessProperty;

    /** 合作渠道id */
    private String companyChannelId;

    /** 保单同步状态：0未同步/1已同步/2同步异常 */
    private Byte syncStatus;

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
    private Date tciPolicyEndDate;

    /** 商业险续保到期日期 */
    private Date vciPolicyEndDate;

    /** 保单类别：0线上/1线下 */
    private Byte isOffline;

    /** 报价是否删除：0未删/1已删 */
    private Byte isDeleted;

    /** 快保 */
    private String channel0;

    /** 大童 */
    private String channel1;

    /** 区域中心 */
    private String channel2;

    /** 地区公司 */
    private String channel3;

    /** 分公司 */
    private String channel4;

    /** 营业部 */
    private String channel5;

    /** 服务部 */
    private String channel6;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode == null ? null : sourceCode.trim();
    }

    public Byte getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Byte companyId) {
        this.companyId = companyId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
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
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo == null ? null : proposalNo.trim();
    }

    public String getTciProposalNo() {
        return tciProposalNo;
    }

    public void setTciProposalNo(String tciProposalNo) {
        this.tciProposalNo = tciProposalNo == null ? null : tciProposalNo.trim();
    }

    public String getVciProposalNo() {
        return vciProposalNo;
    }

    public void setVciProposalNo(String vciProposalNo) {
        this.vciProposalNo = vciProposalNo == null ? null : vciProposalNo.trim();
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getTciPolicyNo() {
        return tciPolicyNo;
    }

    public void setTciPolicyNo(String tciPolicyNo) {
        this.tciPolicyNo = tciPolicyNo == null ? null : tciPolicyNo.trim();
    }

    public String getVciPolicyNo() {
        return vciPolicyNo;
    }

    public void setVciPolicyNo(String vciPolicyNo) {
        this.vciPolicyNo = vciPolicyNo == null ? null : vciPolicyNo.trim();
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
        this.tciStatusMessage = tciStatusMessage == null ? null : tciStatusMessage.trim();
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
        this.vciStatusMessage = vciStatusMessage == null ? null : vciStatusMessage.trim();
    }

    public Byte getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(Byte policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getProtocolCode() {
        return protocolCode;
    }

    public void setProtocolCode(String protocolCode) {
        this.protocolCode = protocolCode == null ? null : protocolCode.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getBusinessProperty() {
        return businessProperty;
    }

    public void setBusinessProperty(String businessProperty) {
        this.businessProperty = businessProperty == null ? null : businessProperty.trim();
    }

    public String getCompanyChannelId() {
        return companyChannelId;
    }

    public void setCompanyChannelId(String companyChannelId) {
        this.companyChannelId = companyChannelId == null ? null : companyChannelId.trim();
    }

    public Byte getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Byte syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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

    public Byte getIsOffline() {
        return isOffline;
    }

    public void setIsOffline(Byte isOffline) {
        this.isOffline = isOffline;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getChannel0() {
        return channel0;
    }

    public void setChannel0(String channel0) {
        this.channel0 = channel0 == null ? null : channel0.trim();
    }

    public String getChannel1() {
        return channel1;
    }

    public void setChannel1(String channel1) {
        this.channel1 = channel1 == null ? null : channel1.trim();
    }

    public String getChannel2() {
        return channel2;
    }

    public void setChannel2(String channel2) {
        this.channel2 = channel2 == null ? null : channel2.trim();
    }

    public String getChannel3() {
        return channel3;
    }

    public void setChannel3(String channel3) {
        this.channel3 = channel3 == null ? null : channel3.trim();
    }

    public String getChannel4() {
        return channel4;
    }

    public void setChannel4(String channel4) {
        this.channel4 = channel4 == null ? null : channel4.trim();
    }

    public String getChannel5() {
        return channel5;
    }

    public void setChannel5(String channel5) {
        this.channel5 = channel5 == null ? null : channel5.trim();
    }

    public String getChannel6() {
        return channel6;
    }

    public void setChannel6(String channel6) {
        this.channel6 = channel6 == null ? null : channel6.trim();
    }
}