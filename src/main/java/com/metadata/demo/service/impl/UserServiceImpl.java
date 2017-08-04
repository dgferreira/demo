package com.metadata.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metadata.demo.domain.User;
import com.metadata.demo.exception.DemoException;
import com.metadata.demo.repository.UserRepository;
import com.metadata.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public User salvar(User user) {
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public User findByUsername(String name) {
		User user = userRepository.findByUsername(name);
		
		if(user == null){
			throw DemoException.USER_NOT_FOUND;
		}
		return user;
	}

	@Override
	@Transactional
	public User editar(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		User user = userRepository.findById(id);
		
		if (user == null){
			throw DemoException.USER_NOT_FOUND;
		}
		
		return user;
	}


}
