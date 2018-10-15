package com.security.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.security.bean.CustomUserDetails;

public interface SecurityTool {

	 /**
	 * 自动登录
	 * @param user
	 * @param clientId
	 * @param scope
	 * @return
	 */
	 OAuth2AccessToken autoLogin(CustomUserDetails user, String clientId, String scope);
}
