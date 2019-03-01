/**
 * 
 */
package com.imooc.security.core.social.qq.connet;

import java.nio.charset.Charset;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhailiang
 *
 */
public class QQOAuth2Template extends OAuth2Template {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 * @param clientId
	 * @param clientSecret
	 * @param authorizeUrl  引导用户到认证服务器同意授权的一个地址
	 * @param accessTokenUrl 同意授权后返回的一个授权码  ，拿这个授权码去认证服务器获取access_token的地址
	 */
	public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
		setUseParametersForClientAuthentication(true);
	}
	
	/** 获取access_token */
	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		String responseStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
		
		logger.info("获取accessToke的响应："+responseStr);
		
		String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(responseStr, "&");
		
		String accessToken = StringUtils.substringAfterLast(items[0], "=");
		Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));
		String refreshToken = StringUtils.substringAfterLast(items[2], "=");
		
		return new AccessGrant(accessToken, null, refreshToken, expiresIn);
	}
	
	/**
	 org.springframework.social.oauth2.OAuth2Template.postForAccessGrant(String, MultiValueMap<String, String>)
	 org.springframework.social.oauth2.OAuth2Template.createRestTemplate()
	 重写下面这个类的作用 可以参考上面这行代码 
	 程序去获取access_token是由springSocial来自动获取的，通过调用postForAccessGrant方法，而默认实现是要求服务提供商那边返回json或者form-url-encoding
	 这种数据才可正常处理
	 而qq提供商那边返回的是字符串 故加入以下代码
	 * */
	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = super.createRestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate;
	}

}
