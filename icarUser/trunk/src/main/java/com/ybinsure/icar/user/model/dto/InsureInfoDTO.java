package com.ybinsure.icar.user.model.dto;

/**
 * 投保信息
 *
 * @author HANHT
 * @version 2018/7/18 14:13
 */
public class InsureInfoDTO {

    /** 投保地-省编码 */
    private String insureProvince;
    /** 投保地-市编码 */
    private String insureCity;

    public String getInsureProvince() {
        return insureProvince;
    }

    public void setInsureProvince(String insureProvince) {
        this.insureProvince = insureProvince;
    }

    public String getInsureCity() {
        return insureCity;
    }

    public void setInsureCity(String insureCity) {
        this.insureCity = insureCity;
    }
}
