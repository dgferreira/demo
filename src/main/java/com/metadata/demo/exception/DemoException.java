package com.metadata.demo.exception;

import org.springframework.http.HttpStatus;

public class DemoException {

	 public static final WebException USER_NOT_FOUND = new WebException(HttpStatus.PRECONDITION_FAILED, "exception.User.notFound");
	
	 private DemoException(){
		 
	 }
	 
}
