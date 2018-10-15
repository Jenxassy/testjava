package com.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.Mydao;
import com.entity.Test;
import com.security.bean.CustomUserDetails;

@Service
public class CustomUserService implements UserDetailsService{

    @Autowired
    private Mydao dao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		List<Test> tests = dao.findByA(userName);
		if(tests.size()>0) {
			return new CustomUserDetails(tests.get(0).getA());
		}
		return null;
	}

}
