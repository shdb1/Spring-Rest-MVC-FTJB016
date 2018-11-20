package com.shadab.spring.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerWithoutResponseBody {
	
// RestController= Controller + ResponseBody annotations
	
	@RequestMapping("/restwithoutresponsebody")
	public String restController() {
		
		return "hey i have been sent without response body annottaion";
	}
	
	@RequestMapping("/restwithoutresponsebodyxml")
	public String restControllerXML() {
		String myResponse = "<xml><name>Ram</name><roll>123</roll></xml>";
		return myResponse;
	}
	
	


}
