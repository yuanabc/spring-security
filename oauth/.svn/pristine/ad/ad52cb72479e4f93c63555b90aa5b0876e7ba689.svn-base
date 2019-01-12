package com.ybinsure.auth.model.transfer.datong;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * 快报加密登录用户信息
 *
 * @author HANHT
 * @version 2018/7/10 19:38
 */
public class UserLoginDTO {

    /** 业务员名称 */
    private String realName;
    /** 名称 */
    private String storeName;
    /** 手机号 */
    private String phone;
    /** 渠道编号 */
    private String channelNum;
    /** 证件类型 */
    private String idType;
    /** 证件号码 */
    private String idNo;
    /** 营业执照号 */
    private String saleId;
    /** 业务员工号 */
    private String agentCode;
    /** 服务部编号 */
    private String agentgroup;
    /** 服务部名称 */
    private String comname;
    /** 是否在职 */
    private String isEmployee;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentgroup() {
        return agentgroup;
    }

    public void setAgentgroup(String agentgroup) {
        this.agentgroup = agentgroup;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(String isEmployee) {
        this.isEmployee = isEmployee;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }

    public Optional<UserDO> convert() {
        boolean matchCondition = StringUtils.isNotBlank(getRealName()) && StringUtils.isNotBlank(getPhone()) && StringUtils.isNotBlank(getChannelNum());
        if (!matchCondition) {
            return Optional.empty();
        }
        UserDO res = new UserDO();
        res.setUserName(getPhone());
        res.setIdName(getRealName());
        res.setPhone(getPhone());
        res.setChannelCode(getChannelNum());
        res.setIdNo(getIdNo());
        res.setSaleNo(getSaleId());
        res.setAgentCode(getAgentCode());
        res.setStatus(StatusCode.ENABLE);
        return Optional.of(res);
    }

    public String getConvertAgentGroup() {
        if (StringUtils.isNotBlank(agentgroup) && agentgroup.startsWith("14")) {
            return agentgroup.replaceFirst("14", "18");
        }
        return agentgroup;
    }

    public UserDO getUpdateParam(UserDO exist) {
        UserDO param = new UserDO();
        param.setId(exist.getId());
        if (!StringUtils.equals(getPhone(), exist.getPhone())) {
            param.setUserName(getPhone());
            param.setPhone(getPhone());
        }
        if (!StringUtils.equals(getRealName(), exist.getIdName())) {
            param.setIdName(getRealName());
        }
        if (!StringUtils.equals(getIdNo(), exist.getIdNo())) {
            param.setIdNo(getIdNo());
        }
        if (!StringUtils.equals(getSaleId(), exist.getSaleNo())) {
            param.setSaleNo(getSaleId());
        }
        return param;
    }

    public boolean isUpdated(UserDO exist) {
        return !StringUtils.equals(getPhone(), exist.getPhone()) ||
                !StringUtils.equals(getRealName(), exist.getIdName()) ||
                !StringUtils.equals(getIdNo(), exist.getIdNo()) ||
                !StringUtils.equals(getSaleId(), exist.getSaleNo()) ||
                !StringUtils.equals(getConvertAgentGroup(), exist.getTeamCompany().map(CompanyDO::getOldCode).orElse(null));
    }

    public boolean isUpdatePhone(UserDO exist) {
        return !StringUtils.equals(getPhone(), exist.getPhone());
    }

    public boolean isUpdateCompany(UserDO exist) {
        return !StringUtils.equals(getConvertAgentGroup(), exist.getTeamCompany().map(CompanyDO::getOldCode).orElse(null));
    }
}
