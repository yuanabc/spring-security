package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ybinsure.icar.user.config.CustomDoubleSerialize;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 最近报价记录数据结果对象
 *
 * @author HANHT
 * @version 2018/7/9 11:43
 */
public class QuoteInfoVO {

    /** 订单编号 */
    private String orderId;
    /** 报价时间 */
    private Long quoteTime;
    /** 保险公司id */
    private Byte companyId;
    /** 保险公司名称 */
    private String companyName;
    /** 总保费 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double totalPremium;
    /** 是否成功 */
    @JsonIgnore
    private Byte policyStatus;
    /** 是否成功 */
    private Byte isSuccess;
    /** 车牌号 */
    private String licenseNo;
    /** 车架号/vin */
    private String frameNo;
    /** 车主名称 */
    private String ownerName;
    /** 该车牌报价次数 */
    private Integer countQuote;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(Long quoteTime) {
        this.quoteTime = quoteTime;
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

    public Byte getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(Byte policyStatus) {
        this.policyStatus = policyStatus;
    }

    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getCountQuote() {
        return countQuote;
    }

    public void setCountQuote(Integer countQuote) {
        this.countQuote = countQuote;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
