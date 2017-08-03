package com.metadata.demo.config;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.metadata.demo.exception.DemoException;
import com.metadata.demo.service.AuthenticationService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private AuthenticationService authenticationService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		logger.info("Name = " + name + " ,Password = " + password);
				
		UserDetails userDetails = authenticationService.loadUserByUsername(name);
				
		if(password.isEmpty()){
			throw DemoException.PASSWORD_NOT_FOUND;
		}else if (!password.equals(userDetails.getPassword())){
			throw DemoException.PASSWORD_INCORRECT;
		}
		
		logger.info("Succesful authentication!");
				
		authentication.isAuthenticated();
		
    	return new UsernamePasswordAuthenticationToken(userDetails, password, new ArrayList<>());	
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
