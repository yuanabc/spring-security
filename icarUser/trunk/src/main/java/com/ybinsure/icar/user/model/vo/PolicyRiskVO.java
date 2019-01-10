package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ybinsure.icar.user.config.CustomDoubleSerialize;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 保单险种信息结果对象
 *
 * @author HANHT
 * @version 2018/7/9 20:17
 */
public class PolicyRiskVO {

    /** 险种代码 */
    private String riskCode;

    /** 险种名称 */
    private String riskName;

    /** 保额 */
    private Double amount;

    /** 保费 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double premium;

    /** 数量：司机/乘客险，司机1，乘客：车座数-1 */
    private Byte quantity;

    /** 单位保额：司机/乘客险 */
    private Integer unitAmount;

    /** 玻璃类型：0国产/1进口，投保玻璃险 */
    private Byte glassType;

    /** 是否投保不计免赔(0:否, 1:是) */
    private Byte isDeductible;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
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

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
