package com.ybinsure.icar.user.wallet.dto;

/**
 * 爱员工对接的
 * @author lic
 *
 */
public class Certification implements IObject{

	private String name	;//Y	string	姓名
	private String idcard	;//Y	string	身份证
	private String validType	;//Y	string	实名认证类型：2二要素认证（姓名+身份证）3三要素认证（姓名+身份证+银行卡）4四要素认证（姓名+身份证+银行卡+手机）
	private String mobile	;//Y	string	手机号。如validT;//Ype=4，此项必须填写绑定银行卡预留手机，参与实名认证；其他情况下，可填其他手机号码，不参与实名认证。
	private String  payAccountType;//YAccountT;//Ype	N	string	第三方收款账号类型，目前支持：
	private String payAccount;
	private String bankName;
	
	private String signType	;//Y	string	签名类型(统一为RSA)
	private String sign	;//Y	string	签名
	private String nonce;//Y	string	返回请求字段nonce的原始内容
	private String timestamp	;//Y	string	时间戳
	private String requestId	;//Y	string	请求标识原样返回
	private String extrSystemId;
	
	private String cerRequestId;
	
	public String getCerRequestId() {
		return cerRequestId;
	}

	public void setCerRequestId(String cerRequestId) {
		this.cerRequestId = cerRequestId;
	}

	
	public String getExtrSystemId() {
		return extrSystemId;
	}
	public void setExtrSystemId(String extrSystemId) {
		this.extrSystemId = extrSystemId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getValidType() {
		return validType;
	}

	public void setValidType(String validType) {
		this.validType = validType;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPayAccountType() {
		return payAccountType;
	}
	public void setPayAccountType(String payAccountType) {
		this.payAccountType = payAccountType;
	}
	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	
}
