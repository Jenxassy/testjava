package com.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.OAuth2ExceptionRenderer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.context.request.ServletWebRequest;



@Configuration
public class ExceptionRender {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 登录前没有权限等等问题会进入这里
	 * @return
	 */
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
		authenticationEntryPoint.setExceptionRenderer(new OAuth2ExceptionRenderer() {
			@Override
			public void handleHttpEntityResponse(HttpEntity<?> responseEntity, ServletWebRequest webRequest)
					throws Exception {
				OAuth2Exception body = (OAuth2Exception) responseEntity.getBody();
				HttpServletResponse res = (HttpServletResponse) webRequest.getNativeResponse();
				ResultBean resultBean = new ResultBean();
				if (body.getOAuth2ErrorCode().equals(OAuth2Exception.INVALID_TOKEN)) {
					resultBean.setCode(ConstantConfig.SELECT_OAUTH2_ERROR.code);
					resultBean.setStatus(false);
					resultBean.setMsg(ConstantConfig.SELECT_OAUTH2_ERROR.text);
					log.error(ConstantConfig.SELECT_OAUTH2_ERROR.text + " a invalid token");
				} else if (body.getOAuth2ErrorCode().equals("unauthorized")) {
					resultBean.setCode(ConstantConfig.SELECT_OAUTH2_CLIENT_ERROR.code);
					resultBean.setStatus(false);
					resultBean.setMsg(ConstantConfig.SELECT_OAUTH2_CLIENT_ERROR.text);
					log.error(ConstantConfig.SELECT_OAUTH2_CLIENT_ERROR.text + " unauthorized client");
				} else if (body.getOAuth2ErrorCode().equals(OAuth2Exception.ACCESS_DENIED)) {
					resultBean.setCode(ConstantConfig.SELECT_OAUTH2_DENIED_ERROR.code);
					resultBean.setStatus(false);
					resultBean.setMsg(ConstantConfig.SELECT_OAUTH2_DENIED_ERROR.text);
					log.error(ConstantConfig.SELECT_OAUTH2_DENIED_ERROR.text + " access denied");
				}else {
					log.error(body.getOAuth2ErrorCode());
				}
			}
		});
		return authenticationEntryPoint;
	}

	/**
	 * 登录后没有权限等等问题会进入这里
	 * @return
	 */
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {

			@Override
			public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException ade)
					throws IOException, ServletException {
				ResultBean resultBean = new ResultBean();
				resultBean.setCode(ConstantConfig.SELECT_OAUTH2_NORIGHT_ERROR.code);
				resultBean.setStatus(false);
				resultBean.setMsg(ConstantConfig.SELECT_OAUTH2_NORIGHT_ERROR.text);
				log.error(ConstantConfig.SELECT_OAUTH2_NORIGHT_ERROR.text + " has no right");
			}
		};
	}

}
