package com.metadata.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

	@GetMapping("/livre")
	public String livre(){
		return "home livre";
	}
	
	@GetMapping("/fechada")
	public String fechada(){
		return "admin";
	}
	
	@GetMapping("/users")
	public String users(){
		return "usuário";
	}
	
}
