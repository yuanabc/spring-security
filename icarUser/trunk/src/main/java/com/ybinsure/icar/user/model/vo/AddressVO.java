package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 保单配送地址结果对象
 *
 * @author HANHT
 * @version 2018/7/7 17:08
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressVO {

    /** 数据id */
    private Integer addrId;
    /** 收件人名称 */
    private String name;
    /** 收件人联系电话 */
    private String phone;
    /** 收件地址 */
    private String address;
    /** 是否默认地址 */
    private Byte isDefault;
    /** 邮箱 */
    private String email;

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
