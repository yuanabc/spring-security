package com.ybinsure.icar.user.model.dto;

/**
 * 工号查询参数
 *
 * @author HANHT
 * @version 2018/7/11 15:50
 */
public class IcarChannelDTO {

    /** 交管地区编码 */
    private String areaCode;
    /** 是否需要查询中华联合 */
    private Byte query;

    public IcarChannelDTO() {
    }

    public IcarChannelDTO(String areaCode, Byte query) {
        this.areaCode = areaCode;
        this.query = query;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Byte getQuery() {
        return query;
    }

    public void setQuery(Byte query) {
        this.query = query;
    }
}
