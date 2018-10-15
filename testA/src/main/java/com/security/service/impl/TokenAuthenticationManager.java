package com.security.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.security.bean.CustomUserDetails;

@Component
public class TokenAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserDetailsService userService;
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = authentication.getName();
	        String password = (String) authentication.getCredentials();
	        CustomUserDetails user = (CustomUserDetails) userService.loadUserByUsername(username);
	        if(user == null){
	            throw new BadCredentialsException("Username not found.");
	        }

	        //加密过程在这里体现
	        if (!password.equals(user.getPassword())) {
	            throw new BadCredentialsException("Wrong password.");
	        }

	        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
	        return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

}
