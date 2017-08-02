package com.metadata.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/livre")
	public String livre(){
		return "home livre";
	}
	
	@GetMapping("/fechada")
	public String fechada(){
		return "admin";
	}
	
}
