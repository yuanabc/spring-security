package com.ybinsure.icar.user.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 保单结果传输对象
 *
 * @author HANHT
 * @version 2018/7/8 20:21
 */
public class PolicyInfoDTO {

    /** 主键UUID */
    private String policyId;

    /** 原ic_order表orderid */
    private String orderId;

    /** 业务员id */
    private String userId;

    /** 投保保险公司id */
    private Byte companyId;

    /** 投保保险公司名称 */
    private String companyName;

    /** 交强险起保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciStartDate;

    /** 交强险终保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciEndDate;

    /** 商业险起保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciStartDate;

    /** 商业险终保日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciEndDate;

    /** 总保费 */
    private Double totalPremium;

    /** 交强险保费 */
    private Double tciPremium;

    /** 商业险保费 */
    private Double vciPremium;

    /** 车船税 */
    private Double vehicleTax;

    /** 交强险出险次数 */
    private Byte tciLossOccurredCount;

    /** 商业险出险次数 */
    private Byte vciLossOccurredCount;

    /** 交强险折扣 */
    private Double tciDiscount;

    /** 商业险折扣 */
    private Double vciDiscount;

    /** 交强险佣金 */
    private Double tciCommission;

    /** 商业险佣金 */
    private Double vciCommission;

    /** 电子保单收件人姓名 */
    private String receiveName;

    /** 电子保单收件人地址 */
    private String receiveAddress;

    /** 电子保单收件人电话 */
    private String receivePhone;

    /** 投保单号 */
    private String proposalNo;

    /** 交强险投保单号 */
    private String tciProposalNo;

    /** 商业险投保单号 */
    private String vciProposalNo;

    /** 支付号 */
    private String payNo;

    /** 综合保单号 */
    private String policyNo;

    /** 交强险保单号 */
    private String tciPolicyNo;

    /** 商业险保单号 */
    private String vciPolicyNo;

    /** 交强险保单状态：0待审核/1审核通过/2下发修改 */
    private Byte tciPolicyStatus;

    /** 交强险保单状态描述 */
    private String tciStatusMessage;

    /** 商业险保单状态：0待审核/1审核通过/2下发修改 */
    private Byte vciPolicyStatus;

    /** 商业险保单状态描述 */
    private String vciStatusMessage;

    /** 保单状态 0未支付/1已支付，生成保单成功/2支付失败/3已支付，生成保单失败/4已支付，保单生成中 */
    private Byte policyStatus;

    /** 报价失败原因/核保失败原因/同步失败原因 */
    private String reason;

    /** 报价时间 */
    private Long quoteTime;

    /** 投保时间 */
    private Long insureTime;

    /** 支付时间 */
    private Long payTime;

    /** 生成保单时间 */
    private Long policyTime;

    /** 交强险续保到期日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tciPolicyEndDate;

    /** 商业险续保到期日期 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date vciPolicyEndDate;

    /** 快保 */
    private String channel0;

    /** 大童 */
    private String channel1;

    /** 区域中心 */
    private String channel2;

    /** 地区公司 */
    private String channel3;

    /** 分公司 */
    private String channel4;

    /** 营业部 */
    private String channel5;

    /** 服务部 */
    private String channel6;

    // 车辆信息
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

    // 人员信息
    /** 车主名称 */
    private String ownerName;

    /** 车主联系方式 */
    private String ownerPhone;

    /** 车主证件类型(101:身份证,102:护照,103:军人证,104:港澳通行证,105:台胞证,201:统一社会信用代码,202:组织机构代码,203:税务登记证,204:营业执照,299:其他,301:统一社会信用代码,302:组织机构代码,303:税务登记证,304:营业执照,399:其他) */
    private String ownerIdType;

    /** 车主证件号 */
    private String ownerIdNo;

    /** 车主联系地址 */
    private String ownerAddr;

    /** 车主出生日期 */
    private Date ownerBirthday;

    /** 车主性别(0:女,1:男) */
    private Byte ownerSex;

    /** 车主邮箱 */
    private String ownerEmail;

    /** 投保人名称 */
    private String holderName;

    /** 投保人联系方式 */
    private String holderPhone;

    /** 投保人证件类型((101:身份证,102:护照,103:军人证,104:港澳通行证,105:台胞证,201:统一社会信用代码,202:组织机构代码,203:税务登记证,204:营业执照,299:其他,301:统一社会信用代码,302:组织机构代码,303:税务登记证,304:营业执照,399:其他)) */
    private String holderIdType;

    /** 投保人证件号 */
    private String holderIdNo;

    /** 投保人联系地址 */
    private String holderAddr;

    /** 投保人出生日期 */
    private Date holderBirthday;

    /** 投保人性别(0:女,1:男) */
    private Byte holderSex;

    /** 被保人名称 */
    private String insuredName;

    /** 被保人联系方式 */
    private String insuredPhone;

    /** 被保人证件类型((101:身份证,102:护照,103:军人证,104:港澳通行证,105:台胞证,201:统一社会信用代码,202:组织机构代码,203:税务登记证,204:营业执照,299:其他,301:统一社会信用代码,302:组织机构代码,303:税务登记证,304:营业执照,399:其他)) */
    private String insuredIdType;

    /** 被保人证件号 */
    private String insuredIdNo;

    /** 被保人联系地址 */
    private String insuredAddr;

    /** 被保人出生日期 */
    private Date insuredBirthday;

    /** 被保人性别(0:女,1:男) */
    private Byte insuredSex;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Byte getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Byte companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getTciStartDate() {
        return tciStartDate;
    }

    public void setTciStartDate(Date tciStartDate) {
        this.tciStartDate = tciStartDate;
    }

    public Date getTciEndDate() {
        return tciEndDate;
    }

    public void setTciEndDate(Date tciEndDate) {
        this.tciEndDate = tciEndDate;
    }

    public Date getVciStartDate() {
        return vciStartDate;
    }

    public void setVciStartDate(Date vciStartDate) {
        this.vciStartDate = vciStartDate;
    }

    public Date getVciEndDate() {
        return vciEndDate;
    }

    public void setVciEndDate(Date vciEndDate) {
        this.vciEndDate = vciEndDate;
    }

    public Double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public Double getTciPremium() {
        return tciPremium;
    }

    public void setTciPremium(Double tciPremium) {
        this.tciPremium = tciPremium;
    }

    public Double getVciPremium() {
        return vciPremium;
    }

    public void setVciPremium(Double vciPremium) {
        this.vciPremium = vciPremium;
    }

    public Double getVehicleTax() {
        return vehicleTax;
    }

    public void setVehicleTax(Double vehicleTax) {
        this.vehicleTax = vehicleTax;
    }

    public Byte getTciLossOccurredCount() {
        return tciLossOccurredCount;
    }

    public void setTciLossOccurredCount(Byte tciLossOccurredCount) {
        this.tciLossOccurredCount = tciLossOccurredCount;
    }

    public Byte getVciLossOccurredCount() {
        return vciLossOccurredCount;
    }

    public void setVciLossOccurredCount(Byte vciLossOccurredCount) {
        this.vciLossOccurredCount = vciLossOccurredCount;
    }

    public Double getTciDiscount() {
        return tciDiscount;
    }

    public void setTciDiscount(Double tciDiscount) {
        this.tciDiscount = tciDiscount;
    }

    public Double getVciDiscount() {
        return vciDiscount;
    }

    public void setVciDiscount(Double vciDiscount) {
        this.vciDiscount = vciDiscount;
    }

    public Double getTciCommission() {
        return tciCommission;
    }

    public void setTciCommission(Double tciCommission) {
        this.tciCommission = tciCommission;
    }

    public Double getVciCommission() {
        return vciCommission;
    }

    public void setVciCommission(Double vciCommission) {
        this.vciCommission = vciCommission;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getTciProposalNo() {
        return tciProposalNo;
    }

    public void setTciProposalNo(String tciProposalNo) {
        this.tciProposalNo = tciProposalNo;
    }

    public String getVciProposalNo() {
        return vciProposalNo;
    }

    public void setVciProposalNo(String vciProposalNo) {
        this.vciProposalNo = vciProposalNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getTciPolicyNo() {
        return tciPolicyNo;
    }

    public void setTciPolicyNo(String tciPolicyNo) {
        this.tciPolicyNo = tciPolicyNo;
    }

    public String getVciPolicyNo() {
        return vciPolicyNo;
    }

    public void setVciPolicyNo(String vciPolicyNo) {
        this.vciPolicyNo = vciPolicyNo;
    }

    public Byte getTciPolicyStatus() {
        return tciPolicyStatus;
    }

    public void setTciPolicyStatus(Byte tciPolicyStatus) {
        this.tciPolicyStatus = tciPolicyStatus;
    }

    public String getTciStatusMessage() {
        return tciStatusMessage;
    }

    public void setTciStatusMessage(String tciStatusMessage) {
        this.tciStatusMessage = tciStatusMessage;
    }

    public Byte getVciPolicyStatus() {
        return vciPolicyStatus;
    }

    public void setVciPolicyStatus(Byte vciPolicyStatus) {
        this.vciPolicyStatus = vciPolicyStatus;
    }

    public String getVciStatusMessage() {
        return vciStatusMessage;
    }

    public void setVciStatusMessage(String vciStatusMessage) {
        this.vciStatusMessage = vciStatusMessage;
    }

    public Byte getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(Byte policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(Long quoteTime) {
        this.quoteTime = quoteTime;
    }

    public Long getInsureTime() {
        return insureTime;
    }

    public void setInsureTime(Long insureTime) {
        this.insureTime = insureTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getPolicyTime() {
        return policyTime;
    }

    public void setPolicyTime(Long policyTime) {
        this.policyTime = policyTime;
    }

    public Date getTciPolicyEndDate() {
        return tciPolicyEndDate;
    }

    public void setTciPolicyEndDate(Date tciPolicyEndDate) {
        this.tciPolicyEndDate = tciPolicyEndDate;
    }

    public Date getVciPolicyEndDate() {
        return vciPolicyEndDate;
    }

    public void setVciPolicyEndDate(Date vciPolicyEndDate) {
        this.vciPolicyEndDate = vciPolicyEndDate;
    }

    public String getChannel0() {
        return channel0;
    }

    public void setChannel0(String channel0) {
        this.channel0 = channel0;
    }

    public String getChannel1() {
        return channel1;
    }

    public void setChannel1(String channel1) {
        this.channel1 = channel1;
    }

    public String getChannel2() {
        return channel2;
    }

    public void setChannel2(String channel2) {
        this.channel2 = channel2;
    }

    public String getChannel3() {
        return channel3;
    }

    public void setChannel3(String channel3) {
        this.channel3 = channel3;
    }

    public String getChannel4() {
        return channel4;
    }

    public void setChannel4(String channel4) {
        this.channel4 = channel4;
    }

    public String getChannel5() {
        return channel5;
    }

    public void setChannel5(String channel5) {
        this.channel5 = channel5;
    }

    public String getChannel6() {
        return channel6;
    }

    public void setChannel6(String channel6) {
        this.channel6 = channel6;
    }

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

    public String getOwnerIdType() {
        return ownerIdType;
    }

    public void setOwnerIdType(String ownerIdType) {
        this.ownerIdType = ownerIdType;
    }

    public String getOwnerIdNo() {
        return ownerIdNo;
    }

    public void setOwnerIdNo(String ownerIdNo) {
        this.ownerIdNo = ownerIdNo;
    }

    public String getOwnerAddr() {
        return ownerAddr;
    }

    public void setOwnerAddr(String ownerAddr) {
        this.ownerAddr = ownerAddr;
    }

    public Date getOwnerBirthday() {
        return ownerBirthday;
    }

    public void setOwnerBirthday(Date ownerBirthday) {
        this.ownerBirthday = ownerBirthday;
    }

    public Byte getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(Byte ownerSex) {
        this.ownerSex = ownerSex;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderPhone() {
        return holderPhone;
    }

    public void setHolderPhone(String holderPhone) {
        this.holderPhone = holderPhone;
    }

    public String getHolderIdType() {
        return holderIdType;
    }

    public void setHolderIdType(String holderIdType) {
        this.holderIdType = holderIdType;
    }

    public String getHolderIdNo() {
        return holderIdNo;
    }

    public void setHolderIdNo(String holderIdNo) {
        this.holderIdNo = holderIdNo;
    }

    public String getHolderAddr() {
        return holderAddr;
    }

    public void setHolderAddr(String holderAddr) {
        this.holderAddr = holderAddr;
    }

    public Date getHolderBirthday() {
        return holderBirthday;
    }

    public void setHolderBirthday(Date holderBirthday) {
        this.holderBirthday = holderBirthday;
    }

    public Byte getHolderSex() {
        return holderSex;
    }

    public void setHolderSex(Byte holderSex) {
        this.holderSex = holderSex;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredPhone() {
        return insuredPhone;
    }

    public void setInsuredPhone(String insuredPhone) {
        this.insuredPhone = insuredPhone;
    }

    public String getInsuredIdType() {
        return insuredIdType;
    }

    public void setInsuredIdType(String insuredIdType) {
        this.insuredIdType = insuredIdType;
    }

    public String getInsuredIdNo() {
        return insuredIdNo;
    }

    public void setInsuredIdNo(String insuredIdNo) {
        this.insuredIdNo = insuredIdNo;
    }

    public String getInsuredAddr() {
        return insuredAddr;
    }

    public void setInsuredAddr(String insuredAddr) {
        this.insuredAddr = insuredAddr;
    }

    public Date getInsuredBirthday() {
        return insuredBirthday;
    }

    public void setInsuredBirthday(Date insuredBirthday) {
        this.insuredBirthday = insuredBirthday;
    }

    public Byte getInsuredSex() {
        return insuredSex;
    }

    public void setInsuredSex(Byte insuredSex) {
        this.insuredSex = insuredSex;
    }
}
