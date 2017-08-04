package com.metadata.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{id}")
	public UserDTO editar(@PathVariable Long id, @RequestBody UserDTO userDto){
		
		User user = userService.findById(id);
		user.setUsername(userDto.getName());
		user.setPassword(userDto.getPassword());
		user = userService.editar(user);
		
		UserDTO result = new UserDTO();
		result.setId(user.getId());
		result.setName(user.getUsername());
		result.setPassword(user.getPassword());
		
		return result;
	}
	
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        User user = userService.findById(id);
        userService.delete(user);
    }
	
    @GetMapping
    public List<UserDTO> findAll(){
    	List<UserDTO> result = new ArrayList<UserDTO>();
    	
    	List<User> lista = userService.findAll();
    	for (User user : lista) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getUsername());
			userDTO.setPassword(user.getPassword());
			result.add(userDTO);
		}
    	
    	return result;
    }
    
    @GetMapping("/{id}")
	public UserDTO buscaUserPorId(@PathVariable Long id){
    	User user = userService.findById(id);
    	
    	UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getUsername());
		userDTO.setPassword(user.getPassword());
    	
    	return userDTO;
	}
}
