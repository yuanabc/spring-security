package com.ybinsure.icar.user.model.param;

import com.ybinsure.icar.user.annotation.DeleteAction;
import com.ybinsure.icar.user.annotation.InsertAction;
import com.ybinsure.icar.user.annotation.QueryAction;
import com.ybinsure.icar.user.annotation.UpdateAction;
import com.ybinsure.icar.user.model.AuthInfo;
import com.ybinsure.icar.user.util.JsonUtil;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 客户接口入参
 *
 * @author HANHT
 * @version 2018/7/8 10:59
 */
public class CustomerParam extends AuthInfo {

    /** 客户数据编号 */
    @NotNull(groups = {QueryAction.class, UpdateAction.class, DeleteAction.class}, message = "客户数据编号不能为空")
    @Min(value = 1, message = "客户数据编号不异常")
    private Integer customerId;
    /** 车牌号 */
    @NotBlank(groups = InsertAction.class, message = "车牌号不能为空")
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 7, message = "车牌号内容太长")
    private String licenseNo;
    /** 车主姓名 */
    @NotBlank(groups = InsertAction.class, message = "车主名称不能为空")
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 32, message = "车主名称内容太长")
    private String ownerName;
    /** 联系电话 */
    @NotBlank(groups = InsertAction.class, message = "联系电话不能为空")
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 15, message = "联系电话内容太长")
    private String ownerPhone;
    /** 车型 */
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 50, message = "车型内容太长")
    private String brandName;
    /** 车架号 */
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 17, message = "车架号内容太长")
    private String frameNo;
    /** 往年投保公司 */
    private Integer lastCompanyId;
    /** 交强险止期 */
    @DateTimeFormat
    private String tciEndDate;
    /** 商业险止期 */
    private String vciEndDate;
    /** 备注 */
    private String remark;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public Integer getLastCompanyId() {
        return lastCompanyId;
    }

    public void setLastCompanyId(Integer lastCompanyId) {
        this.lastCompanyId = lastCompanyId;
    }

    public String getTciEndDate() {
        return tciEndDate;
    }

    public void setTciEndDate(String tciEndDate) {
        this.tciEndDate = tciEndDate;
    }

    public String getVciEndDate() {
        return vciEndDate;
    }

    public void setVciEndDate(String vciEndDate) {
        this.vciEndDate = vciEndDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
