package com.shadab.spring.rest.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpStatusDemoController {
	
	@RequestMapping(value="/httpstaus/{resourcename}",method=RequestMethod.GET)
	public String myGetApi(@PathVariable("resourcename") String name,HttpServletResponse response) {
		
		
		// db call for name
		
		System.out.println("name is:"+name);
		
		if(name.equalsIgnoreCase("cognizant"))
			response.setStatus(HttpStatus.OK.value());
		else
			response.setStatus(HttpStatus.NOT_FOUND.value());
			
		
		
		
		
		return "list of data";
	}
	
	
	@RequestMapping(value="/responseentitydemo/{resourcename}",method=RequestMethod.GET)
	public ResponseEntity<UserBean> myTestApi(@PathVariable("resourcename") String name,HttpServletResponse response) {
		System.out.println("reached");
		UserBean userBean = new UserBean();
		userBean.setData("testdata");
		userBean.setMessage("success");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("name", "johny");
		ResponseEntity responseEntity = new ResponseEntity<UserBean>(userBean,httpHeaders,HttpStatus.CREATED);
		
		
		
		return responseEntity;
	}
	
	@RequestMapping(value="/customresponse/{resourcename}",method=RequestMethod.GET)
	public CongnizantEntity myTestApiWitrhCustomResponseBean(@PathVariable("resourcename") String name,HttpServletResponse response) {
		System.out.println("reached");
		UserBean userBean = new UserBean();
		userBean.setData("testdata");
		userBean.setMessage("success");
		
		CongnizantEntity congnizantEntity = new CongnizantEntity(HttpStatus.CREATED, "hello how are you");
		
		
		return congnizantEntity;
	}

	@RequestMapping(value="/exceptionhandlerdemo/{resourcename}",method=RequestMethod.GET)
	public CongnizantEntity myTestApiWitrhCustomResponseBeanExceptionHandling(@PathVariable("resourcename") String name,HttpServletResponse response) {
		System.out.println("reached");
		UserBean userBean = new UserBean();
		userBean.setData("testdata");
		userBean.setMessage("success");
		
		CongnizantEntity congnizantEntity = new CongnizantEntity(HttpStatus.CREATED, "hello how are you");
		
		String data= null;
		data.length();
		
		return congnizantEntity;
	}	
	

}

class UserBean{
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	String message;
	Object data;
}

class CongnizantEntity{
	HttpStatus statusCode;
	public CongnizantEntity(HttpStatus statusCode, String body) {
		super();
		this.statusCode = statusCode;
		this.body = body;
	}
	String body;
	
	
}


