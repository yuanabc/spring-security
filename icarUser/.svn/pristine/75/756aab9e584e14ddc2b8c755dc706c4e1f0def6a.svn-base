package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ybinsure.icar.user.util.JsonUtil;

import java.util.Date;

/**
 * 保单车辆信息结果对象
 *
 * @author HANHT
 * @version 2018/7/9 21:15
 */
public class PolicyVehicleVO {

    /** 车牌号 */
    private String licenseNo;

    /** 品牌型号 */
    private String brandName;

    /** 车型编码 */
    private String modelCode;

    /** 车架号/vin */
    private String frameNo;

    /** 发动机号 */
    private String engineNo;

    /** 初登日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date enrollDate;

    /** 年款 */
    private String issueYear;

    /** 新车价格 */
    private Integer purchasePrice;

    /** 实际价格 */
    private Double actualPrice;

    /** 座位数 */
    private Byte seatCount;

    /** 过户日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date transferDate;

    /** 排量/功率 */
    private Double displacement;

    /** 整备质量 */
    private Double curbWeight;

    /** 核定载质量 */
    private Double tonnage;

    /** 交管车辆类型 */
    private String vehicleType;

    /** 车辆种类 */
    private String vehicleCategory;

    /** 车辆使用性质(100:非营业, 200营业) */
    private String useNature;

    /** 使用性质细分(车辆使用性质选择为营业时 201:出租租赁, 202:城市公交, 203:公路客运, 204:旅游客运) */
    private String attachNature;

    /** 号牌种类(101:小型汽车、102:大型汽车、103:小型新能源汽车、104:大型新能源汽车、199:其他车型) */
    private String plateType;

    /** 号牌底色(101:蓝,102:黑,103:白,104:黄,105:白蓝,106:黄绿,107:渐变绿,199:其他) */
    private String plateColor;

    /** 能源类型(101:燃油, 102:纯电动, 103:软料电池, 104:插电式混合动力, 199:其他混合动力) */
    private String energyType;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Byte getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Byte seatCount) {
        this.seatCount = seatCount;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public Double getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(Double curbWeight) {
        this.curbWeight = curbWeight;
    }

    public Double getTonnage() {
        return tonnage;
    }

    public void setTonnage(Double tonnage) {
        this.tonnage = tonnage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getUseNature() {
        return useNature;
    }

    public void setUseNature(String useNature) {
        this.useNature = useNature;
    }

    public String getAttachNature() {
        return attachNature;
    }

    public void setAttachNature(String attachNature) {
        this.attachNature = attachNature;
    }

    public String getPlateType() {
        return plateType;
    }

    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
