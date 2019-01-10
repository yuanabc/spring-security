package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ybinsure.icar.user.util.JsonUtil;

import java.util.Date;

/**
 * 客户查询结果对象
 *
 * @author HANHT
 * @version 2018/7/7 19:28
 */
public class CustomerVO {

    /** 数据编号 */
    private Integer customerId;
    /** 交强险止期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciEndDate;
    /** 商业险止期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciEndDate;
    /** 车牌号 */
    private String licenseNo;
    /** 车主姓名 */
    private String ownerName;
    /** 车主联系电话 */
    private String ownerPhone;
    /** 车架号 */
    private String frameNo;
    /** 车型名称 */
    private String brandName;
    /** 备注 */
    private String remark;

    /** 往年最新投保的公司 */
    private Integer lastCompanyId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getTciEndDate() {
        return tciEndDate;
    }

    public void setTciEndDate(Date tciEndDate) {
        this.tciEndDate = tciEndDate;
    }

    public Date getVciEndDate() {
        return vciEndDate;
    }

    public void setVciEndDate(Date vciEndDate) {
        this.vciEndDate = vciEndDate;
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

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLastCompanyId() {
        return lastCompanyId;
    }

    public void setLastCompanyId(Integer lastCompanyId) {
        this.lastCompanyId = lastCompanyId;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
