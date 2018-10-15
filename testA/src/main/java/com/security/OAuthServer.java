package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class OAuthServer extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint point;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false);
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http.exceptionHandling().authenticationEntryPoint(point).and()
		        .requestMatchers().antMatchers("/login", "/oauth/authorize").and()
				.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/oauth/**").permitAll()
				.anyRequest().authenticated().and().
				formLogin().permitAll();
	}

}
