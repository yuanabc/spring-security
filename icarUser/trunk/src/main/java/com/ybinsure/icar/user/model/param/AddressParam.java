package com.ybinsure.icar.user.model.param;

import com.ybinsure.icar.user.annotation.DeleteAction;
import com.ybinsure.icar.user.annotation.InsertAction;
import com.ybinsure.icar.user.annotation.UpdateAction;
import com.ybinsure.icar.user.model.AuthInfo;
import com.ybinsure.icar.user.util.JsonUtil;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 保单配送地址入参对象
 *
 * @author HANHT
 * @version 2018/7/7 18:20
 */
public class AddressParam extends AuthInfo {

    /** 地址数据id */
    @NotNull(groups = {UpdateAction.class, DeleteAction.class}, message = "地址数据编号不能为空")
    @Min(value = 1, message = "地址数据编号异常")
    private Integer addrId;
    /** 收件人 */
    @NotBlank(groups = {InsertAction.class}, message = "收件人名称不能为空")
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 30, message = "名称内容太长")
    private String name;
    /** 手机号 */
    @NotBlank(groups = {InsertAction.class}, message = "收件人手机号不能为空")
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 11, message = "手机号内容太长")
    private String phone;
    /** 详细地址 */
    @NotBlank(groups = {InsertAction.class}, message = "详细地址不能为空")
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 100, message = "地址内容太长")
    private String address;
    /** 是否默认地址 */
    private Integer isDefault;
    /** 邮箱 */
    @Length(groups = {InsertAction.class, UpdateAction.class}, max = 50, message = "邮箱内容太长")
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

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
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
