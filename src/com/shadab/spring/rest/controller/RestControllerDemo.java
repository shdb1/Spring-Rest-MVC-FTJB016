package com.shadab.spring.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//1.controller annotations - controller , responsebody
//2.Rest Controller annotation


@Controller
public class RestControllerDemo {
	
	@RequestMapping("/testapi")
	@ResponseBody
	public String apiDemo() {
		
		System.out.println("Api has recvd a request");
		
		return "{name:shadab,country:india}";
		
	}

}
