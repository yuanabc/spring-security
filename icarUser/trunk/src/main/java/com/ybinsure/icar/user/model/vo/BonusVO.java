package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ybinsure.icar.user.config.CustomDoubleSerialize;

/**
 * 奖金列表数据
 *
 * @author HANHT
 * @version 2018/6/28 11:54
 */
public class BonusVO {

    /** 车牌号 */
    private String licenseNo;
    /** 用户名 */
    private String userName;
    /** 奖金 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double amount;
    /** 奖金时间 */
    private String bonusTime;
    /** 奖金状态 */
    private Integer bonusState;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBonusTime() {
        return bonusTime;
    }

    public void setBonusTime(String bonusTime) {
        this.bonusTime = bonusTime;
    }

    public Integer getBonusState() {
        return bonusState;
    }

    public void setBonusState(Integer bonusState) {
        this.bonusState = bonusState;
    }
}
