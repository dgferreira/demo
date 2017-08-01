package com.metadata.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String Hello(){
		return "Teste";
	}
	
}
