package com.shadab.spring.rest.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
 

@RestController
public class DummyController {
	
/*	
	@RequestMapping(value = "/dummy", method = RequestMethod.POST)
	public Student getDummyEmployee(@RequestBody Student st) {
		System.out.println("st--->"+st.getName());
		System.out.println("st--->"+st.getName());

		Map<Integer, Student> empData = new HashMap<Integer, Student>();
	//	logger.info("Start getDummyEmployee");
		Student emp = new Student(11,"test");


		return emp;
	}
	*/
	//ResponseEntityExceptionHandler
	
	@RequestMapping(value = "/dummy/my/{test}/wer", method = RequestMethod.POST)
	public ResponseEntity<List> getDummyEmployee(@RequestBody Student st,@PathVariable("test") String test) {
		System.out.println("st--->"+st.getName());
		System.out.println("st--->"+st.getName());
		System.out.println("test--->"+test);

		Map<Integer, Student> empData = new HashMap<Integer, Student>();
		List<Student>  list = new ArrayList<Student>();
	//	logger.info("Start getDummyEmployee");
		Student emp = new Student(11,"test");
		Student emp1 = new Student(11,"22");
		HttpHeaders header = new HttpHeaders();
		header.add("shadabkey", "shadabvalue");
		list.add(emp);
		list.add(emp1);
		ResponseEntity re = new ResponseEntity<>(list, header, HttpStatus.BAD_GATEWAY);
		MyEntity myentity = new MyEntity();
		myentity.setBody(list);
		myentity.setHeaders(header);
		//myentity.setHttpStatus(HttpStatus.BAD_GATEWAY);
		// make function call pass url-

		return re;
	}
	
}


@XmlRootElement(name="hey")
class Student implements Serializable{

	//private static final long serialVersionUID = -7788619177798333712L;
	
	private int id;
	private String name;
	
	public Student(int id,String name ) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Student( ) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 
	
	
}

@ControllerAdvice
class DummyEx extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		System.out.println("not su[[orted"+ex.getMessage()+"--"+status);
		return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
	}
	
	@ExceptionHandler(value=Exception.class)
	public String data() {
		
		return "";
	}
	
}

class MyEntity<T>{
	HttpStatus httpStatus;
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public HttpHeaders getHeaders() {
		return headers;
	}
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	public Object getBody() {
		return (T)body;
	}
	public void setBody(Object body) {
		T t = (T)body;
		this.body = t;
	}
	HttpHeaders headers;
	Object body;
	
}

