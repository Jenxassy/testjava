package com.security.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Service;

import com.security.bean.CustomUserDetails;
import com.security.service.SecurityTool;

@Service
public class SecurityToolImpl implements SecurityTool {

	@Autowired
	private AuthorizationServerTokenServices tokenservices;
    
	@Autowired
    private AuthenticationManager manager;//自定义验证
	
	
    // 自动登录
	@Override
	public OAuth2AccessToken autoLogin(CustomUserDetails user, String clientId, String scope) {
		Authentication token = new UsernamePasswordAuthenticationToken(user, user.getPassword(),user.getAuthorities());
		manager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(token);
		
		Map<String, String> requestParameters = new HashMap<String,String>();
		requestParameters.put("grant_type", "password");
		requestParameters.put("client_id", clientId);
		requestParameters.put("username", user.getUsername());
		requestParameters.put("scope", scope);
		
		Set<String> scopes = new HashSet<String>();
		scopes.add(scope);
		OAuth2Request oauth = new OAuth2Request(requestParameters,clientId,user.getAuthorities(),true,scopes,null,null,null,null);
		return tokenservices.createAccessToken(new OAuth2Authentication(oauth, token));
	}

	 // 退出登录就是不传入token，原token便会失效，同个客户端，同个用户返回是同一个token
}
