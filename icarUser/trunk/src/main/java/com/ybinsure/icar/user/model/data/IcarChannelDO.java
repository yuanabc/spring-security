package com.ybinsure.icar.user.model.data;

import java.io.Serializable;
import java.util.Objects;

public class IcarChannelDO implements Serializable {
    private Integer id;

    /** 保险公司id */
    private Integer companyId;

    /** 绑定的02级别的分公司代码 */
    private String comcodes;

    /** 账号/对应大地保险的前端传送字段 */
    private String account;

    /** 密码/对应大地保险的代理人名字字段 */
    private String pwd;

    /** 公司代码/对应大地保险代理人代码字段 */
    private String companyCode;

    /** 员工代码/代理协议号/对应大地保险许可证号字段 */
    private String userCode;

    /** 税务名称 */
    private String taxName;

    /** 税务代码 */
    private String taxCode;

    /** 凭证号 */
    private String voucherNo;

    /** 服务区域代码 */
    private String serviceCode;

    /** 代理点代码 */
    private String orgCode;

    /** 经办人代码/出单员代码 */
    private String managersCode;

    /** 城市id */
    private Integer cityId;

    /** 0:正式账号,1:测试账号 */
    private Integer type;

    private Long times;

    /** 描述 */
    private String explains;

    /** 渠道 */
    private String sourceId;

    /** 是否在正式环境显示 */
    private Byte isShow;

    private Integer del;

    private String field01;

    private String field02;

    private String field03;

    private String field04;

    private String field05;

    private String field06;

    private String field07;

    /** 政策划分区域代码 */
    private Integer areaCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getComcodes() {
        return comcodes;
    }

    public void setComcodes(String comcodes) {
        this.comcodes = comcodes == null ? null : comcodes.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName == null ? null : taxName.trim();
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode == null ? null : taxCode.trim();
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo == null ? null : voucherNo.trim();
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getManagersCode() {
        return managersCode;
    }

    public void setManagersCode(String managersCode) {
        this.managersCode = managersCode == null ? null : managersCode.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains == null ? null : explains.trim();
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getField01() {
        return field01;
    }

    public void setField01(String field01) {
        this.field01 = field01 == null ? null : field01.trim();
    }

    public String getField02() {
        return field02;
    }

    public void setField02(String field02) {
        this.field02 = field02 == null ? null : field02.trim();
    }

    public String getField03() {
        return field03;
    }

    public void setField03(String field03) {
        this.field03 = field03 == null ? null : field03.trim();
    }

    public String getField04() {
        return field04;
    }

    public void setField04(String field04) {
        this.field04 = field04 == null ? null : field04.trim();
    }

    public String getField05() {
        return field05;
    }

    public void setField05(String field05) {
        this.field05 = field05 == null ? null : field05.trim();
    }

    public String getField06() {
        return field06;
    }

    public void setField06(String field06) {
        this.field06 = field06 == null ? null : field06.trim();
    }

    public String getField07() {
        return field07;
    }

    public void setField07(String field07) {
        this.field07 = field07 == null ? null : field07.trim();
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IcarChannelDO that = (IcarChannelDO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}