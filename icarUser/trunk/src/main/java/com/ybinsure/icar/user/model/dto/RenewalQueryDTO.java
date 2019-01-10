package com.ybinsure.icar.user.model.dto;

/**
 * 飞哥续保查询接口返回对象
 *
 * @author HANHT
 * @version 2018/7/11 18:02
 */
public class RenewalQueryDTO {

    /** ID	bigint(20) */
    private String carId;
    /** 车牌号	char(10) */
    private String carLicense;
    /** 发动机号	varchar(90) */
    private String carEngine;
    /** 车架号	varchar(30) */
    private String carVin;
    /** 车型名称	varchar(50) */
    private String carName;
    /** 车型编码	varchar(20) */
    private String carCode;
    /** 排量功率	char(10) */
    private String carExhaust;
    /** 车辆价格	varchar(20) */
    private String carPrice;
    /** 车年款	varchar(10) */
    private String carYear;
    /** 整备质量	varchar(10) */
    private String carQuality;
    /** 座位	int(11) */
    private String carSeat;
    /** 初登日期	date */
    private String carFirstDate;
    /** 过户日期	date */
    private String carTransferDate;
    /** 保险公司ID	varchar(10) */
    private String companyId;
    /** 交强险终保时间	date */
    private String policyEndForce;
    /** 交强险保单号	varchar(30) */
    private String policyForce;
    /** 交强费用	varchar(10) */
    private String costForce;
    /** 商业险终保时间	date */
    private String policyEndCom;
    /** 商业险保单号	varchar(30) */
    private String policyCom;
    /** 商业费用	varchar(20) */
    private String costCom;
    /** 保费折扣	varchar(10) */
    private String costDiscount;
    /** 车主证件类型	varchar(10) */
    private String type1;
    /** 车主名称	varchar(80) */
    private String name1;
    /** 车主证件号码	varchar(30) */
    private String card1;
    /** 车主地址	varchar(80) */
    private String addr1;
    /** 车主手机	varchar(20) */
    private String mobile1;
    /** 被保人证件类型	varchar(10) */
    private String type2;
    /** 被保人名称	varchar(80) */
    private String name2;
    /** 被保人证件号码	varchar(30) */
    private String card2;
    /** 被保人地址	varchar(80) */
    private String addr2;
    /** 被保人手机	varchar(20) */
    private String mobile2;
    /** 投保人证件类型	varchar(10) */
    private String type3;
    /** 投保人名称	varchar(80) */
    private String name3;
    /** 投保人证件号码	varchar(30) */
    private String card3;
    /** 投保人地址	varchar(80) */
    private String addr3;
    /** 投保人手机	varchar(20) */
    private String mobile3;
    /** 车损险/保费	varchar(10) */
    private String a0;
    /** 车损险不计免赔/保费	varchar(10) */
    private String b0;
    /** 车损险保额	varchar(10) */
    private String c0;
    /** 盗抢险/保费	varchar(10) */
    private String a1;
    /** 盗抢险不计免赔/保费	varchar(10) */
    private String b1;
    /** 盗抢险保额	varchar(10) */
    private String c1;
    /** 三者险/保费	varchar(10) */
    private String a2;
    /** 三者险不计免赔/保费	varchar(10) */
    private String b2;
    /** 三者险保额	varchar(10) */
    private String c2;
    /** 司机险/保费	varchar(10) */
    private String a3;
    /** 司机险不计免赔/保费	varchar(10) */
    private String b3;
    /** 司机险保额	varchar(10) */
    private String c3;
    /** 乘客险/保费	varchar(10) */
    private String a4;
    /** 乘客险不计免赔/保费	varchar(10) */
    private String b4;
    /** 乘客险保额	varchar(10) */
    private String c4;
    /** 划痕险/保费	varchar(10) */
    private String a5;
    /** 划痕险不计免赔/保费	varchar(10) */
    private String b5;
    /** 划痕险保额	varchar(10) */
    private String c5;
    /** 破碎险/保费	varchar(10) */
    private String a6;
    /** 修理险/保费	varchar(10) */
    private String a7;
    /** 自燃险/保费	varchar(10) */
    private String a8;
    /** 自燃险不计免赔/保费	varchar(10) */
    private String b8;
    /** 自燃险保额	varchar(10) */
    private String c8;
    /** 涉水险/保费	varchar(10) */
    private String a9;
    /** 涉水险不计免赔/保费	varchar(10) */
    private String b9;
    /** 特约险/保费	varchar(10) */
    private String a10;
    /**  */
    private String createTime;
    /**  */
    private String updateTime;
    /**  */
    private String offset;
    /** 车辆使用性质 */
    private String useNature;
    /** 使用性质细分 */
    private String attachNature;
    /** 车辆种类 */
    private String carKind;
    /** 号牌种类 */
    private String plateType;
    /** 号牌底色 */
    private String plateColor;
    /** 能源类型 */
    private String energyType;
    /** 核定载质量 */
    private String tonnage;
    /** 车主出生日期 */
    private String birthday1;
    /** 车主性别 */
    private String sex1;
    /** 被别人出生日期 */
    private String birthday2;
    /** 被别人性别 */
    private String sex2;
    /** 投保人出生日期 */
    private String birthday3;
    /** 投保人性别 */
    private String sex3;
    /** 邮箱 */
    private String email;
    /** 车辆类型 */
    private String carType;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarExhaust() {
        return carExhaust;
    }

    public void setCarExhaust(String carExhaust) {
        this.carExhaust = carExhaust;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getCarQuality() {
        return carQuality;
    }

    public void setCarQuality(String carQuality) {
        this.carQuality = carQuality;
    }

    public String getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(String carSeat) {
        this.carSeat = carSeat;
    }

    public String getCarFirstDate() {
        return carFirstDate;
    }

    public void setCarFirstDate(String carFirstDate) {
        this.carFirstDate = carFirstDate;
    }

    public String getCarTransferDate() {
        return carTransferDate;
    }

    public void setCarTransferDate(String carTransferDate) {
        this.carTransferDate = carTransferDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPolicyEndForce() {
        return policyEndForce;
    }

    public void setPolicyEndForce(String policyEndForce) {
        this.policyEndForce = policyEndForce;
    }

    public String getPolicyForce() {
        return policyForce;
    }

    public void setPolicyForce(String policyForce) {
        this.policyForce = policyForce;
    }

    public String getCostForce() {
        return costForce;
    }

    public void setCostForce(String costForce) {
        this.costForce = costForce;
    }

    public String getPolicyEndCom() {
        return policyEndCom;
    }

    public void setPolicyEndCom(String policyEndCom) {
        this.policyEndCom = policyEndCom;
    }

    public String getPolicyCom() {
        return policyCom;
    }

    public void setPolicyCom(String policyCom) {
        this.policyCom = policyCom;
    }

    public String getCostCom() {
        return costCom;
    }

    public void setCostCom(String costCom) {
        this.costCom = costCom;
    }

    public String getCostDiscount() {
        return costDiscount;
    }

    public void setCostDiscount(String costDiscount) {
        this.costDiscount = costDiscount;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getCard1() {
        return card1;
    }

    public void setCard1(String card1) {
        this.card1 = card1;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getCard3() {
        return card3;
    }

    public void setCard3(String card3) {
        this.card3 = card3;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getMobile3() {
        return mobile3;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getA0() {
        return a0;
    }

    public void setA0(String a0) {
        this.a0 = a0;
    }

    public String getB0() {
        return b0;
    }

    public void setB0(String b0) {
        this.b0 = b0;
    }

    public String getC0() {
        return c0;
    }

    public void setC0(String c0) {
        this.c0 = c0;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }

    public String getA8() {
        return a8;
    }

    public void setA8(String a8) {
        this.a8 = a8;
    }

    public String getB8() {
        return b8;
    }

    public void setB8(String b8) {
        this.b8 = b8;
    }

    public String getC8() {
        return c8;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    public String getA9() {
        return a9;
    }

    public void setA9(String a9) {
        this.a9 = a9;
    }

    public String getB9() {
        return b9;
    }

    public void setB9(String b9) {
        this.b9 = b9;
    }

    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
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

    public String getCarKind() {
        return carKind;
    }

    public void setCarKind(String carKind) {
        this.carKind = carKind;
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

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public String getBirthday1() {
        return birthday1;
    }

    public void setBirthday1(String birthday1) {
        this.birthday1 = birthday1;
    }

    public String getSex1() {
        return sex1;
    }

    public void setSex1(String sex1) {
        this.sex1 = sex1;
    }

    public String getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(String birthday2) {
        this.birthday2 = birthday2;
    }

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    public String getBirthday3() {
        return birthday3;
    }

    public void setBirthday3(String birthday3) {
        this.birthday3 = birthday3;
    }

    public String getSex3() {
        return sex3;
    }

    public void setSex3(String sex3) {
        this.sex3 = sex3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
