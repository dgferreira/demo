package com.metadata.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metadata.demo.domain.User;
import com.metadata.demo.exception.DemoException;
import com.metadata.demo.repository.UserRepository;
import com.metadata.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User salvar(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findByUsername(String name) {
		User user = userRepository.findByUsername(name);
		
		if(user == null){
			throw DemoException.USER_NOT_FOUND;
		}
		return user;
	}


}
