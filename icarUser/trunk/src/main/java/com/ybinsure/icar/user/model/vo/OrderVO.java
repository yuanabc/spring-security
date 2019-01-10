package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ybinsure.icar.user.config.CustomDoubleSerialize;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 保单列表结果对象
 *
 * @author HANHT
 * @version 2018/7/8 15:56
 */
public class OrderVO {

    /** 订单编号 */
    private String orderId;
    /** 时间 */
    private Long orderTime;
    /** 保险公司id */
    private Byte companyId;
    /** 保险公司名称 */
    private String companyName;
    /** 总保费 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double totalPremium;
    /** 订单状态 */
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

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
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
