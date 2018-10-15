package com.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.security.service.impl.RedisTokenStoreFix;


/**
 * BasicAuthenticationFilter 里面拦截了只能通过http传auth header
 * @author Administrator
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
    private AuthenticationManager manager;//自定义验证
	
	@Autowired
    private RedisConnectionFactory redisConnectionFactory;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		// 不开启任何特殊通道
		//oauthServer.allowFormAuthenticationForClients();
		oauthServer.passwordEncoder(new BCryptPasswordEncoder());


	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		   .withClient("clientId")
		   .secret(new BCryptPasswordEncoder().encode("secret"))
		   .scopes("scopes")  // 如果scope未定义或者为空（默认值），则客户端作用域不受限制。
		   .authorities("ROLE")
		   .authorizedGrantTypes("authorization_code","refresh_token","password")
		   .autoApprove(true);
	}

	//@Autowired
	//private UserDetailsService service;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.approvalStoreDisabled()
						.tokenEnhancer(tokenEnhancer())
						.authenticationManager(manager)  // 必须得加上，不然没有密码验证
						.tokenStore(new RedisTokenStoreFix(redisConnectionFactory));	
	}
	
/*
	@Bean
	// 为了其他方式可以自主登录，需要把TokenService暴露出来
	public AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices service = new DefaultTokenServices();
		service.setTokenEnhancer(tokenEnhancer());
		service.setTokenStore(new RedisTokenStoreFix(redisConnectionFactory));	
		return service;
	}
 */

	
	/**
	 * 获取Token接口返回追加信息
	 * @return
	 */
	  @Bean
	    public TokenEnhancer tokenEnhancer(){
	        return new TokenEnhancer() {
	            @Override
	            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	                if (accessToken instanceof DefaultOAuth2AccessToken){
	                    DefaultOAuth2AccessToken token= (DefaultOAuth2AccessToken) accessToken;
	                    Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();
	                    additionalInformation.put("username",authentication.getName());
	                    token.setAdditionalInformation(additionalInformation);
	                }
	                return accessToken;
	            }
	        };
	    }
}
