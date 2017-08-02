package com.metadata.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metadata.demo.domain.User;
import com.metadata.demo.dto.UserDTO;
import com.metadata.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserDTO salvar(@RequestBody UserDTO userDto){
		
		User user = new User();
		user.setUsername(userDto.getName());
		user.setPassword(userDto.getPassword());
		user = userService.salvar(user);
		
		UserDTO result = new UserDTO();
		result.setId(user.getId());
		result.setName(user.getUsername());
		result.setPassword(user.getPassword());
		
		return result;
	}
}
