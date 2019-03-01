/**
 * 
 */
package com.imooc.security.core.social;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import com.imooc.security.core.properties.SecurityProperties;

/**
 * @author zhailiang
 * 社交配置主类
 *
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SecurityProperties securityProperties;
	
	//这个要添加required=false防止有些没有实现这个接口并注入
	@Autowired(required = false)
	private ConnectionSignUp connectionSignUp;

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText());
		repository.setTablePrefix("imooc_");
		if(connectionSignUp != null) {//如果不为空就不会跳转到注册页面会自动注册一个业务系统userid与providerId,providerUserId的关联
			repository.setConnectionSignUp(connectionSignUp);
		}
		return repository;
	}

	@Bean
	public SpringSocialConfigurer imoocSocialSecurityConfig() {
		//配置认证时的地址(点击qq图标时跳转地址与在qq互联开发者后台配置地址要一致 用户同意授权回调时也是用此地址)
		String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
		ImoocSpringSocialConfigurer configurer = new ImoocSpringSocialConfigurer(filterProcessesUrl);
		//配置自定义注册地址（在一个第三方系统中你只是同意了使用社交方式授权登陆   但是根据这个授权登陆后的信息  并未找到在此第三方系统中唯一一个用户【
		//select userId from " + tablePrefix + "UserConnection where providerId = ? and providerUserId = ?】  此时就会要求你进行注册
		//org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository.findUserIdsWithConnection(Connection<?>)
		//if (localUserIds.size() == 0 && connectionSignUp != null) {
		//如果 不想让用户跳转到注册页面可以默认实现一个connectionSignUp接口让程序自动注册一个用户
		//如果你之前在这个第三方系统中有注册过   此时就涉及另一个问题把你的社交登陆id与之前注册过的进行一个绑定操作）
		//SocialAuthenticationProvider.authenticate方法中如果抛出BadCredentialsException异常 则
		//org.springframework.social.security.SocialAuthenticationFilter.doAuthentication(SocialAuthenticationService<?>, HttpServletRequest, SocialAuthenticationToken)
		//会捕获异常   并跳转到SocialAuthenticationFilter默认提供的注册页面/signup   
		configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
		return configurer;
	}

	/** 1.在注册过程中如何拿到springsocial中已有的社交帐号信息
	 *  2.注册后如何把这个业务用户信息传给springsocial【和之前社交帐号信息关联（userId，providerId，providerUserId的关联）】 */
	@Bean
	public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
		return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator)) ;
	}
}
