package com.service.thirdparty;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

public interface WxMiniPro{

	OAuth2AccessToken loginWith(String jscode);
}
