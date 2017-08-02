package com.metadata.demo.service;

import com.metadata.demo.domain.User;

public interface UserService {

	User salvar(User user);
	
	User findById(Long id);
	
	User findByUsername(String name);
}
