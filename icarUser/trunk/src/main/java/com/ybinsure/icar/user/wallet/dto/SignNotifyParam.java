package com.ybinsure.icar.user.wallet.dto;



/**
 * 签约异步通知请求参数
 * 
 * @author lijiadeng
 * @date 2018年2月1日 下午5:57:51
 * @version v1.0 深圳市悦保科技有限公司
 */
public class SignNotifyParam extends SignRspCommonParam implements IObject{

	private String impSubStateDesc;
	
    private String partyaSubStateDesc;
    
    private String partybSubStateDesc;
    
    private String partycSubStateDesc;
    
    private String stateDesc;
    
    //订单号(爱员工返回订单号)
    private String orderId;
    
    private Long expireTime;
    
    private Long createTime;
    
    private String partyaUserName;
    
    private String partyaSignUrl;
    
    private Long partyaSignTime;
    
    private String partybUserName;
    
    private String partybSignUrl;
    
    private Long partybSignTime;
    
    private String partycUserName;
    
    private String partycSignUrl;
    
    private Long partycSignTime;
    
    private String state;
    
    private String impSubState;
    
    private String subState;
    
    private String msg;
    
    private String personalName;
    
    private String personalMobile;
    
    private String personalIdentityType;
    
    private String personalIdentity;
    
    private Long lastNotifyTime;
    
    private String outerDownloadUrl;
    
    //外部订单号(系统订单号)
    private String extrOrderId;

    private String extrSystemId;
    
    private String notifyResultcode;
    
    private String notifyResultmessage;
    
    private Long notifyTime;
    
    private String notifyUrl;

	public String getImpSubStateDesc() {
		return impSubStateDesc;
	}

	public void setImpSubStateDesc(String impSubStateDesc) {
		this.impSubStateDesc = impSubStateDesc;
	}

	public String getPartyaSubStateDesc() {
		return partyaSubStateDesc;
	}

	public void setPartyaSubStateDesc(String partyaSubStateDesc) {
		this.partyaSubStateDesc = partyaSubStateDesc;
	}

	public String getPartybSubStateDesc() {
		return partybSubStateDesc;
	}

	public void setPartybSubStateDesc(String partybSubStateDesc) {
		this.partybSubStateDesc = partybSubStateDesc;
	}

	public String getPartycSubStateDesc() {
		return partycSubStateDesc;
	}

	public void setPartycSubStateDesc(String partycSubStateDesc) {
		this.partycSubStateDesc = partycSubStateDesc;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getPartyaUserName() {
		return partyaUserName;
	}

	public void setPartyaUserName(String partyaUserName) {
		this.partyaUserName = partyaUserName;
	}

	public String getPartyaSignUrl() {
		return partyaSignUrl;
	}

	public void setPartyaSignUrl(String partyaSignUrl) {
		this.partyaSignUrl = partyaSignUrl;
	}

	public Long getPartyaSignTime() {
		return partyaSignTime;
	}

	public void setPartyaSignTime(Long partyaSignTime) {
		this.partyaSignTime = partyaSignTime;
	}

	public String getPartybUserName() {
		return partybUserName;
	}

	public void setPartybUserName(String partybUserName) {
		this.partybUserName = partybUserName;
	}

	public String getPartybSignUrl() {
		return partybSignUrl;
	}

	public void setPartybSignUrl(String partybSignUrl) {
		this.partybSignUrl = partybSignUrl;
	}

	public Long getPartybSignTime() {
		return partybSignTime;
	}

	public void setPartybSignTime(Long partybSignTime) {
		this.partybSignTime = partybSignTime;
	}

	public String getPartycUserName() {
		return partycUserName;
	}

	public void setPartycUserName(String partycUserName) {
		this.partycUserName = partycUserName;
	}

	public String getPartycSignUrl() {
		return partycSignUrl;
	}

	public void setPartycSignUrl(String partycSignUrl) {
		this.partycSignUrl = partycSignUrl;
	}

	public Long getPartycSignTime() {
		return partycSignTime;
	}

	public void setPartycSignTime(Long partycSignTime) {
		this.partycSignTime = partycSignTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getImpSubState() {
		return impSubState;
	}

	public void setImpSubState(String impSubState) {
		this.impSubState = impSubState;
	}

	public String getSubState() {
		return subState;
	}

	public void setSubState(String subState) {
		this.subState = subState;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getPersonalMobile() {
		return personalMobile;
	}

	public void setPersonalMobile(String personalMobile) {
		this.personalMobile = personalMobile;
	}

	public String getPersonalIdentityType() {
		return personalIdentityType;
	}

	public void setPersonalIdentityType(String personalIdentityType) {
		this.personalIdentityType = personalIdentityType;
	}

	public String getPersonalIdentity() {
		return personalIdentity;
	}

	public void setPersonalIdentity(String personalIdentity) {
		this.personalIdentity = personalIdentity;
	}

	public Long getLastNotifyTime() {
		return lastNotifyTime;
	}

	public void setLastNotifyTime(Long lastNotifyTime) {
		this.lastNotifyTime = lastNotifyTime;
	}

	public String getOuterDownloadUrl() {
		return outerDownloadUrl;
	}

	public void setOuterDownloadUrl(String outerDownloadUrl) {
		this.outerDownloadUrl = outerDownloadUrl;
	}

	public String getExtrOrderId() {
		return extrOrderId;
	}

	public void setExtrOrderId(String extrOrderId) {
		this.extrOrderId = extrOrderId;
	}

	public String getExtrSystemId() {
		return extrSystemId;
	}

	public void setExtrSystemId(String extrSystemId) {
		this.extrSystemId = extrSystemId;
	}

	public String getNotifyResultcode() {
		return notifyResultcode;
	}

	public void setNotifyResultcode(String notifyResultcode) {
		this.notifyResultcode = notifyResultcode;
	}

	public String getNotifyResultmessage() {
		return notifyResultmessage;
	}

	public void setNotifyResultmessage(String notifyResultmessage) {
		this.notifyResultmessage = notifyResultmessage;
	}

	public Long getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(Long notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	
}
