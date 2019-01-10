package com.ybinsure.icar.user.model.data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @author HANHT
 * @version 2018/7/4 18:5
 */
public class UserDO implements Serializable {
    /** 主键Id */
    private String id;

    /** 唯一编码 */
    private Long code;

    /** 自增长id */
    private Integer oldId;

    /** 登录用户名 */
    private String userName;

    /** 姓名，展示用 */
    private String nickName;

    /** 用户密码 */
    private String password;

    /** 性别 */
    private String sex;

    /** 证件姓名 */
    private String idName;

    /** 手机号码，财务人员需要 */
    private String phone;

    /** 身份证号 */
    private String idNo;

    /** 业务员工号 */
    private String agentCode;

    /** 用户分类 */
    private String userType;

    /** 业务员类型 */
    private String salesType;

    /** 管辖机构是否默认归属机构 */
    private Byte defaultManagerCompany;

    /** 开户银行 */
    private String bank;

    /** 开户人 */
    private String accountHolder;

    /** 银行预留手机号码 */
    private String bankPhone;

    /** 银行卡号 */
    private String bankNo;

    /** 备注信息 */
    private String description;

    /** 原渠道状态，0-可用 1-不可用 */
    private Byte channelStatus;

    /** 逻辑删除 */
    private Byte deleted;

    /** 账户状态,0-启用 1-非启用 */
    private Byte status;

    /** 渠道编码 */
    private String channelCode;

    private Long updateTime;

    private Long createTime;

    /** 权限 0：普通用户 1：普通管理员 2：高级管理员 3：超级管理员 */
    private Byte power;

    /** 0为银联卡，1为支付宝，2为微信 */
    private Byte cardType;

    /** 可提现的钱包，由大童财务存入 */
    private Double wallet;

    /** 提现密码 */
    private String withDrawPwd;

    /** 1:在编,2:有邀请人,3:散户 */
    private Byte type;

    /** 营业执照号 */
    private String saleNo;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName == null ? null : idName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType == null ? null : salesType.trim();
    }

    public Byte getDefaultManagerCompany() {
        return defaultManagerCompany;
    }

    public void setDefaultManagerCompany(Byte defaultManagerCompany) {
        this.defaultManagerCompany = defaultManagerCompany;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder == null ? null : accountHolder.trim();
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone == null ? null : bankPhone.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Byte channelStatus) {
        this.channelStatus = channelStatus;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }

    public Byte getCardType() {
        return cardType;
    }

    public void setCardType(Byte cardType) {
        this.cardType = cardType;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public String getWithDrawPwd() {
        return withDrawPwd;
    }

    public void setWithDrawPwd(String withDrawPwd) {
        this.withDrawPwd = withDrawPwd == null ? null : withDrawPwd.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo == null ? null : saleNo.trim();
    }
}