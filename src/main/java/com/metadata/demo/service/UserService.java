package com.metadata.demo.service;

import java.util.List;

import com.metadata.demo.domain.User;

public interface UserService {

	User salvar(User user);
	
	User editar(User user);
	
	void delete(User user);
    
    List<User> findAll();
	
	User findByUsername(String name);
	
	User findById(Long id);
}
