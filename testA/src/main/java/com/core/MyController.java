package com.core;


import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.Test;
import com.security.bean.CustomUserDetails;
import com.security.service.SecurityTool;
import com.service.MyService;


@RestController
public class MyController {
	@Autowired
	private MyService service;
	
	
	@Autowired
	private SecurityTool tool;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${wxapp.appid}")
	private String appid;
	
	@Value("${wxapp.secret}")
	private String secret;

	@RequestMapping( "/user/info")
	public Map<String,String> enter(Principal principal) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("roles", "admin");
		map.put("name", "超人不会飞");
		map.put("avatar", "http://img06.51jobcdn.com/im/2016/home/default_user_90x110.png");
		return map;
	}
	
	@RequestMapping( "/c")
	public String enter3() {
		
		return "you're authorizeed";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping( "/a")
	public String enter2() {

		return "you're authorizeed";
	}
	
	//https://api.weixin.qq.com/sns/jscode2session?appid=wx60aff903e9667f53&secret=e5e51b1fe0d884ef90a5d64ae3325dc0&js_code=JSCODE&grant_type=authorization_code

	@RequestMapping( "/d")
	public OAuth2AccessToken  ss() {
			return tool.autoLogin(new CustomUserDetails("admin"), "clientId", "scopes");
	}
	
	@RequestMapping( "/e")
	public String  re(@RequestParam("jscode") String jscode) {
	
		 Map<String, String> params =new HashMap<String, String>();  
		 params.put("appid", appid);  
		 params.put("secret", secret);
		 params.put("js_code", jscode);
		 params.put("grant_type", "authorization_code");
		String msg= restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}", String.class , params);
		return msg;
	}
	
	@RequestMapping( "/b")
	public Test hello() {
		service.add("admin");
		Test test = service.getTest("admin");
		System.out.println(test.getId());
		service.update("admin", test.getId());
		test = service.getTest("admin");
		System.out.println(test.getA());
		return test;
	}
	
}


