package com.ybinsure.icar.user.model.param;

import com.ybinsure.icar.user.model.AuthInfo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 续保查询入参
 *
 * @author HANHT
 * @version 2018/7/11 11:59
 */
public class RenewalParam extends AuthInfo {

    /** 车牌号 */
    @NotBlank(message = "车牌号不能为空")
    @Length(max = 7, message = "车牌号内容太长")
    private String licenseNo;
    /** 身份证后6位 */
    @Length(max = 6, message = "身份证后六位输入有误")
    private String cardLastNo;
    /** 车架号/vin */
    private String frameNo;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getCardLastNo() {
        return cardLastNo;
    }

    public void setCardLastNo(String cardLastNo) {
        this.cardLastNo = cardLastNo;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }
}
