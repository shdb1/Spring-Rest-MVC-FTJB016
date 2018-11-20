package com.shadab.spring.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	
	@RequestMapping("/api/v1/student/getstudent/{roll}dd")
	public String getStudent(@PathVariable("roll") String rollnumber) {
		// service call- roll
		//return student
		
		// CRUD -- ORM
		// exception 
		return "testdata";
	}

}
