package com.ybinsure.icar.user.wallet.dto;


/**
 * 签约公共响应参数
 * 
 * @author lijiadeng
 * @date 2018年2月6日 上午10:44:28
 * @version v1.0 深圳市悦保科技有限公司
 */
public class SignRspCommonParam implements IObject{

	/**
	 * 签名
	 */
    private String sign;
	
    /**
     * 返回码 ACCEPTED：处理成功  ACCEPTFAIL:处理失败
     */
	private String resultCode;
	
	/**
	 * 返回码描述
	 */
	private String resultMessage;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	
}
