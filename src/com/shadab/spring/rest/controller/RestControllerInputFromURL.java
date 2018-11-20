package com.shadab.spring.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerInputFromURL {
	
	
@RequestMapping("/getInputs")
public String getInputs(@RequestParam(value="studentroll",required=false,defaultValue="7890") String studentroll) {
	System.out.println("studentroll:"+studentroll);
	return "testdata";
}

// http://localhost:8080/spring-rest/getpnrstatus/<train number>
//http://localhost:8080/spring-rest/getpnrstatus/11436

@RequestMapping("/getInputs/{}")
public String getInputsFromPath(@PathVariable("roll") String studentroll) {
	System.out.println("studentroll:"+studentroll);
	return "testdata";
}




}
