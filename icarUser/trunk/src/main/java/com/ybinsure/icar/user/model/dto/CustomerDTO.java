package com.ybinsure.icar.user.model.dto;

/**
 * 客户数据查询对象
 *
 * @author HANHT
 * @version 2018/7/8 10:21
 */
public class CustomerDTO {

    /** 用户编号 */
    private String userId;
    /** 车主名称 */
    private String ownerName;
    /** 车牌号 */
    private String licenseNo;
    /** 今天日期 */
    private String today;
    /** 到期日期 */
    private String dueDay;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }
}
