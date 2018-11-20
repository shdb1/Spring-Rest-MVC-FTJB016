package com.shadab.spring.rest.controller;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XMLAndJSONReqRespController {

	
	@RequestMapping(value="/jsonxmldemo",method=RequestMethod.POST)
	public Test jsonxmlDemo(@RequestBody Test testObject) {
		System.out.println("jsonxmlDemo is being executed- "+testObject.getTestname()+"   "+testObject.getTestid());
	Test test = new Test(testObject.getTestname()+"Modified", testObject.getTestid()+"-Modified",testObject.getRoll(),testObject.getUname());
		return testObject;
		
	}
	
}


@XmlRootElement(name="mytestobject")
class Test{
	

	
	public Test() {
 		 
	}
	
	public Test(String testname, String testid, String roll, String uname) {
 		this.testname = testname;
		this.testid = testid;
		this.roll = roll;
		this.uname = uname;
	}

	private String testname;
	private String testid;
	private String roll;
	private String uname;
	
	
	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}


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
