package com.shadab.spring.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCodeController {
	
	
	@RequestMapping(value="/gethttpstatus")
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String jsonRequest() {
		System.out.println("gethttpstatus-- executing");
		return "your data is ready to use";
	}
	


}
