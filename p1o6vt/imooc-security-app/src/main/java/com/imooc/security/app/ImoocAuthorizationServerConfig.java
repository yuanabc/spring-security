package com.imooc.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * https://www.cnblogs.com/xingxueliao/p/5911292.html
 * 下面是配置一个授权服务必须要实现的endpoints：
	AuthorizationEndpoint：用来作为请求者获得授权的服务，默认的URL是/oauth/authorize.
	在请求到达/oauth/token之前经过了ClientCredentialsTokenEndpointFilter这个过滤器
	TokenEndpoint：用来作为请求者获得令牌（Token）的服务，默认的URL是/oauth/token.

 * /oauth/token接口地址获取令牌参考以下代码  
 * org.springframework.security.oauth2.provider.endpoint.TokenEndpoint
 * 
 * */
@Configuration
@EnableAuthorizationServer
public class ImoocAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    private static final String DEMO_RESOURCE_ID = "order";


    // 配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
    //用来配置令牌端点(Token Endpoint)的安全约束.
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	//认证服务器为哪些第三方应用发令牌的配置是什么
	//配置OAuth2的客户端相关信息
	//用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		 //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory().withClient("client_1")
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("123456")
                .and().withClient("client_2")
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("123456");
        
        //设置从数据库中读取
//        clients.withClientDetails(clientDetailsService);
	}

	//配置入口点(/oauth/token等)
	//配置AuthorizationServerEndpointsConfigurer众多相关类，包括配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
//	用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService)
		.tokenStore(new RedisTokenStore(redisConnectionFactory));
	}

}
