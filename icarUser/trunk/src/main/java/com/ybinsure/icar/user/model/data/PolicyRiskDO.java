package com.ybinsure.icar.user.model.data;

import java.io.Serializable;

/**
 * 保单关联险种数据
 *
 * @author HANHT
 * @version 2018/7/4 18:17
 */
public class PolicyRiskDO implements Serializable {
    /** 自增长主键 */
    private Long id;

    /** 保单表主键 */
    private String policyId;

    /** 险种代码  */
    private String riskCode;

    /** 险种名称 */
    private String riskName;

    /** 保额 */
    private Double amount;

    /** 保费 */
    private Double premium;

    /** 数量：司机/乘客险，司机1，乘客：车座数-1 */
    private Byte quantity;

    /** 单位保额：司机/乘客险 */
    private Integer unitAmount;

    /** 玻璃类型：0国产/1进口，投保玻璃险 */
    private Byte glassType;

    /** 是否投保不计免赔(0:否, 1:是) */
    private Byte isDeductible;

    /** 不计免赔保费 */
    private Double deductPremium;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode == null ? null : riskCode.trim();
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName == null ? null : riskName.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Byte getQuantity() {
        return quantity;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Integer unitAmount) {
        this.unitAmount = unitAmount;
    }

    public Byte getGlassType() {
        return glassType;
    }

    public void setGlassType(Byte glassType) {
        this.glassType = glassType;
    }

    public Byte getIsDeductible() {
        return isDeductible;
    }

    public void setIsDeductible(Byte isDeductible) {
        this.isDeductible = isDeductible;
    }

    public Double getDeductPremium() {
        return deductPremium;
    }

    public void setDeductPremium(Double deductPremium) {
        this.deductPremium = deductPremium;
    }
}