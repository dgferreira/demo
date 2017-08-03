package com.metadata.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metadata.demo.domain.User;
import com.metadata.demo.exception.DemoException;
import com.metadata.demo.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(name);

		if (user == null) {
			throw DemoException.USER_NOT_FOUND;
		}
		
		UserDetails userDetails = new UserDetails() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return false;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return false;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return false;
			}
			
			@Override
			public String getUsername() {
				return user.getUsername();
			}
			
			@Override
			public String getPassword() {
				return user.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return null;
			}
		};
		
		return userDetails;
	}
}
