package com.metadata.demo.exception;

import org.springframework.http.HttpStatus;

public class DemoException {

	 public static final WebException USER_NOT_FOUND = new WebException(HttpStatus.PRECONDITION_FAILED, "exception.User.notFound");
	 
	 public static final WebException PASSWORD_INCORRECT = new WebException(HttpStatus.PRECONDITION_FAILED, "exception.Password.Incorrect");
	
	 public static final WebException PASSWORD_NOT_FOUND = new WebException(HttpStatus.PRECONDITION_FAILED, "exception.Password.notFound");
	 
	 private DemoException(){
		 
	 }
	 
}
