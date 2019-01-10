package com.ybinsure.icar.user.model.data;

import java.io.Serializable;

/**
 * 平安订单信息
 *
 * @author HANHT
 * @version 2018/7/15 12:37
 */
public class PingAnOrderDO implements Serializable {
    private Integer id;

    private String userId;

    /** 投保人/被保人 */
    private String name;

    /** 车牌号 */
    private String licenseNo;

    /** 订单号 */
    private String orderNo;

    /** 交强险保单号 */
    private String tciPolicyNo;

    /** 商业险保单号 */
    private String vciPolicyNo;

    /** 总保费 */
    private Double totalPremium;

    /** 交强险保费 */
    private Double tciPremium;

    /** 车船税 */
    private Double tax;

    /** 商业险保费 */
    private Double vciPremium;

    /** 录单时间 */
    private Long createDate;

    /** 状态：3核保失败/4核保成功，未缴费/5承保成功/6承保失败 */
    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getVciPremium() {
        return vciPremium;
    }

    public void setVciPremium(Double vciPremium) {
        this.vciPremium = vciPremium;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}