package com.ybinsure.icar.user.wallet.dto;



/**
 * 单笔提交签约请求参数
 * 
 * @author lijiadeng
 * @date 2018年1月31日 下午4:46:23
 * @version v1.0 深圳市悦保科技有限公司
 */
public class SignReqOrderParam implements IObject{

	/**
	 * 外部系统Id
	 */
	private String extrSystemId;
	
    /**
     * 外部订单号
     */
    private String extrOrderId;

    /**
     * 证件号
     */
    private String identity;
    
    /**
     * 证件类型
     */
    private String identityType;

    /**
     * 姓名
     */
    private String name;
    
	/**
	 * 异步通知地址
	 */
	private String notifyUrl;

    /**
     * 手机
     */
    private String personalMobile;
    
    /**
	 * 签名
	 */
	private String sign;
    
	/**
	 * 模板ID
	 */
    private String templateId;

    
	public SignReqOrderParam() {
		super();
	}
	
	public SignReqOrderParam(String extrSystemId, String extrOrderId,
			String identity, String identityType, String name,
			String notifyUrl, String personalMobile, String templateId) {
		super();
		this.extrSystemId = extrSystemId;
		this.extrOrderId = extrOrderId;
		this.identity = identity;
		this.identityType = identityType;
		this.name = name;
		this.notifyUrl = notifyUrl;
		this.personalMobile = personalMobile;
		this.templateId = templateId;
	}

	public String getExtrSystemId() {
		return extrSystemId;
	}

	public void setExtrSystemId(String extrSystemId) {
		this.extrSystemId = extrSystemId;
	}

	public String getExtrOrderId() {
		return extrOrderId;
	}

	public void setExtrOrderId(String extrOrderId) {
		this.extrOrderId = extrOrderId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getPersonalMobile() {
		return personalMobile;
	}

	public void setPersonalMobile(String personalMobile) {
		this.personalMobile = personalMobile;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}


}
