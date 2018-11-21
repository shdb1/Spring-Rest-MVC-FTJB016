package com.shadab.spring.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shadab.spring.rest.model.ErrorBean;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorBean> resourceNotFound() {
		ErrorBean errorBean = new ErrorBean();
		errorBean.setErroMessage("hey iot was dummy resource");
		errorBean.setExtraInfo("you can contact cognizant support @122333");
		ResponseEntity responseEntity = new ResponseEntity<>(errorBean,HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
		
	}

}
