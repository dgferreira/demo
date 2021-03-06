package com.metadata.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{

		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/demo/users").permitAll()
			.antMatchers("/demo/livre").permitAll()
			.antMatchers("/demo/fechada").authenticated()	
		.and()
			.formLogin();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(customAuthenticationProvider);
	}
	
}
