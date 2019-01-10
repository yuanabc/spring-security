package com.ybinsure.icar.user.model.vo;

import com.ybinsure.icar.user.model.dto.OrganizationDTO;
import com.ybinsure.icar.user.util.JsonUtil;

import java.util.List;

/**
 * 账户信息
 *
 * @author HANHT
 * @version 2018/7/15 16:28
 */
public class AccountVO {

    /** 用户id */
    private String userId;
    /** 姓名 */
    private String named;
    /** 联系方式 */
    private String phone;

    /** 省份简称 */
    private String area;
    /** 省份名称 */
    private String provinceName;
    /** 城市名称 */
    private String cityName;
    /** 可用保险公司 */
    private String companys;

    /** 所属机构列表 */
    private List<OrganizationDTO> belongCompany;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCompanys() {
        return companys;
    }

    public void setCompanys(String companys) {
        this.companys = companys;
    }

    public List<OrganizationDTO> getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(List<OrganizationDTO> belongCompany) {
        this.belongCompany = belongCompany;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
