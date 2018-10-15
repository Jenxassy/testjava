package com.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

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

import com.dao.Mydao;
import com.entity.Test;
import com.security.bean.CustomUserDetails;
import com.service.MyService;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private Mydao dao;
    
	@Autowired
	private AuthorizationServerTokenServices tokenservices;
    
	@Autowired
    private AuthenticationManager manager;//自定义验证
    
    @Override
    @Transactional
    public int add(String a) {
    	Test test = new Test();
    	test.setA(a);
    	test = dao.save(test);
    	return test.getId();
    }
    
    @Override
    @Transactional
    public void update(String a,int id) {
    	dao.updateA(a, id);
    }
    @Override
    public Test getTest(String a) {
    	return dao.findByA(a).get(0);
    }
    
}
