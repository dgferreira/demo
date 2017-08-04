package com.metadata.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metadata.demo.DemoApplicationTests;
import com.metadata.demo.domain.User;

public class UserServiceTest extends DemoApplicationTests{

	@Autowired
	private UserService userService;
	
	@Test
	public void salvarUserTest(){
		User dott = new User();
		dott.setUsername("dott");
		dott.setPassword("1234");
		userService.salvar(dott);
		
		User caio = new User();
		caio.setUsername("caio");
		caio.setPassword("123456");
		userService.salvar(caio);
		
		User user = userService.findById(dott.getId());
		assertNotNull(dott.getId());
		assertNotNull(caio.getId());
		assertEquals("1234", user.getPassword());
		
		userService.delete(dott);
		userService.delete(caio);
		
	}
	
	@Test
	public void editarUserTest(){
		User dott = new User();
		dott.setUsername("dott");
		dott.setPassword("1234");
		userService.salvar(dott);
		
		dott.setUsername("douglas");
		dott.setPassword("123456");
		userService.editar(dott);
		
		User user = userService.findById(dott.getId());
		assertEquals(dott.getUsername(), user.getUsername());
		assertEquals(dott.getPassword(), user.getPassword());
		assertEquals("douglas", user.getUsername());
		assertEquals("123456", user.getPassword());
		
		userService.delete(dott);
	}
	
	@Test
	public void listaUserTest(){
		User dott = new User();
		dott.setUsername("dott");
		dott.setPassword("1234");
		userService.salvar(dott);
		
		User caio = new User();
		caio.setUsername("caio");
		caio.setPassword("123456");
		userService.salvar(caio);
		
		User lucas = new User();
		lucas.setUsername("lucas");
		lucas.setPassword("789456");
		userService.salvar(lucas);
		
		List<User> list = userService.findAll();
		assertEquals(3, list.size());
		
		userService.delete(dott);
		userService.delete(caio);
		userService.delete(lucas);
		
	}
	
	@Test
	public void buscaPorUsernameTest(){
		User dott = new User();
		dott.setUsername("dott");
		dott.setPassword("1234");
		userService.salvar(dott);
		
		User caio = new User();
		caio.setUsername("caio");
		caio.setPassword("123456");
		userService.salvar(caio);
		
		User user = userService.findByUsername("dott");
		assertEquals(user.getUsername(), dott.getUsername());
		assertEquals(user.getPassword(), dott.getPassword());
		
		userService.delete(dott);
		userService.delete(caio);
		
	}
	
}
