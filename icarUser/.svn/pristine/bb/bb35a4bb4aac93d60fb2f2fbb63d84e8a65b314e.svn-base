package com.ybinsure.icar.user.model;

import com.ybinsure.icar.user.util.JsonUtil;
import org.hibernate.validator.constraints.Range;

/**
 * 查询条件入参
 *
 * @author HANHT
 * @version 2018/7/7 19:22
 */
public class QueryParam extends PageInfo {

    /** 车牌号 */
    private String licenseNo;
    /** 车主名称 */
    private String ownerName;
    /** 剩余到期天数 */
    private Integer dueDays;
    /** 订单状态：0全部，默认 1待核保 2待支付 3已承保 */
    @Range(min = 0, max = 3, message = "查询类别有误")
    private Integer type;
    /** 车架号 */
    private String frameNo;

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

    public Integer getDueDays() {
        return dueDays;
    }

    public void setDueDays(Integer dueDays) {
        this.dueDays = dueDays;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
