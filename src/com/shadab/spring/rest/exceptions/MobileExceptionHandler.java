package com.shadab.spring.rest.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class MobileExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public void doSomething() {
		
		
	}

}
