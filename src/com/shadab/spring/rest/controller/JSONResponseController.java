package com.shadab.spring.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONResponseController {
	
	
	@RequestMapping("/jsontest")
	public TestPOJO jsonResponse(@RequestParam("testinput") String testinput) {
		System.out.println("testinput:"+testinput);
		TestPOJO testPOJO = new TestPOJO("test", "123");
		return testPOJO;
	}

	
	@RequestMapping(value="/jsontestwithjsonbody",method=RequestMethod.POST)
	public TestPOJO jsonRequest(@RequestBody TestPOJO testObject) {
		System.out.println("id:"+testObject.getTestid());
		System.out.println("id:"+testObject.getTestname());
		TestPOJO testPOJO = new TestPOJO(testObject.getTestname()+"-modified",testObject.getTestid()+"-modified");
		return testPOJO;
	}
	


}

class TestPOJO{
	
	public TestPOJO(String testname, String testid) {
 		this.testname = testname;
		this.testid = testid;
	}
	
	public TestPOJO() {
 		 
	}
	
	private String testname;
	private String testid;
	
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getTestid() {
		return testid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	
}


