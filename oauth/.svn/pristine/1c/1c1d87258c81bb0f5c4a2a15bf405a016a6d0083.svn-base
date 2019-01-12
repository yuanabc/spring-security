package com.ybinsure.auth.model.transfer.param;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.CompanyDO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

public class DatongCompany {

    // 机构名称
    @NotBlank(groups = {InsertAction.class}, message = "comName不能为空")
    private String comName;

    // 机构层级
    @NotBlank(groups = {InsertAction.class}, message = "comGrade不能为空")
    private String comGrade;

    // 省份
    @NotBlank(groups = {InsertAction.class}, message = "province不能为空")
    private String province;

    // 城市
    @NotBlank(groups = {InsertAction.class}, message = "city不能为空")
    private String city;

    // 区县
    private String county;

    // 本机构编码
    @NotBlank(groups = {InsertAction.class}, message = "comCode不能为空")
    private String comCode;

    // 上级机构编码
    @NotBlank(groups = {InsertAction.class}, message = "upComCode不能为空")
    private String upComCode;

    // 负责人
    private String operator;

    // 负责人电话
    private String phone;

    // 机构地址
    private String address;

    // 邮编
    private String zipCode;


    public String convertCompanyType() {
        return StringUtils.equals(getComGrade(), "05") ? CompanyTypeCode.TEAM : CompanyTypeCode.COMPANY;
    }

    public Byte convertCompanyLevel() {
        switch (getComGrade()) {
            case "05":
                return 6;
            case "04":
                return 5;
            case "03":
                return 4;
            case "02":
                return 3;
            case "01":
                return 2;
            case "00":
                return 1;
            default:
                return null;
        }
    }

    public String getConvertComCode() {
        return getConvertCode(getComCode());
    }

    public String getConvertUpComCode() {
        return getConvertCode(getUpComCode());
    }

    public String getConvertCode(String sourceCode) {
        if (StringUtils.isNotBlank(sourceCode) && sourceCode.startsWith("14")) {
            return sourceCode.replaceFirst("14", "18");
        }
        return sourceCode;
    }

    public CompanyDO convertUpdate() {
        CompanyDO companyDO = new CompanyDO();
        companyDO.setOldCode(getConvertComCode());
        companyDO.setName(getComName());
        companyDO.setProvince(getProvince());
        companyDO.setCity(getCity());
        companyDO.setCountry(getCounty());
        companyDO.setPhone(getPhone());
        companyDO.setAddress(getAddress());
        companyDO.setPrincipal(getOperator());
        companyDO.setPostCode(getZipCode());
        return companyDO;
    }

    public CompanyDO convertInsert() {
        CompanyDO companyDO = convertUpdate();
        companyDO.setCompanyType(convertCompanyType());
        companyDO.setLevel(convertCompanyLevel());
        companyDO.setChannelCode(ChannelCode.DA_TONG);
        companyDO.setDeleted(StatusCode.DISABLE);
        companyDO.setStatus(StatusCode.ENABLE);
        return companyDO;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComGrade() {
        return comGrade;
    }

    public void setComGrade(String comGrade) {
        this.comGrade = comGrade;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getUpComCode() {
        return upComCode;
    }

    public void setUpComCode(String upComCode) {
        this.upComCode = upComCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
