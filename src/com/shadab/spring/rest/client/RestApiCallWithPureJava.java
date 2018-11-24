package com.shadab.spring.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestApiCallWithPureJava {
public static void main(String[] args) {
	// just for testing 
	//jsontestwithjsonbody
	
	//getCalls("http://localhost:8080/spring-rest/jsontest?testinput=dummy");
	//getCalls("http://localhost:8080/spring-rest/jsontest?testinput=dummy");
 
	//doPostCall("http://localhost:8080/spring-rest/jsontestwithjsonbody");
	
	restTemplateDemo();
}

public static void getCalls(String endpoint) {
	
	
	try {
		URL url = new URL (endpoint);
	try {
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Accept", "application/json");
		
		
		System.out.println(httpURLConnection.getResponseCode());
		
		
		if(httpURLConnection.getResponseCode()<300) {
		
		BufferedReader myData = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		
		String resultIfApi = "";
		StringBuffer myoutput = new StringBuffer();
		resultIfApi= myData.readLine();
		while( resultIfApi != null)
		{
			
			System.out.println("shuld run forever");
			myoutput.append(resultIfApi);
			resultIfApi= myData.readLine();
			
		}
		System.out.println(myoutput);
		}
		else {
			
			System.out.println("bad status");
		}
		
		httpURLConnection.disconnect();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void doPostCall(String endpoint) {
	

	
	
	try {
		URL url = new URL (endpoint);
	try {
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept", "application/json");
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setDoOutput(true);
		OutputStream outputStream = httpURLConnection.getOutputStream();
		//String myPayload = "{\"testname\":\"test\",\"testid\":\"123\"}\n" + "";
		
		TestPOJO testPOJO = new TestPOJO("newName", "newtestId");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String data = null;
		try {
			data = objectMapper.writeValueAsString(testPOJO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	   outputStream.write(data.getBytes());
		
		System.out.println(httpURLConnection.getResponseCode());
		
		
		if(httpURLConnection.getResponseCode()<300) {
		
		BufferedReader myData = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		
		String resultIfApi = "";
		StringBuffer myoutput = new StringBuffer();
		resultIfApi= myData.readLine();
		while( resultIfApi != null)
		{
			
			System.out.println("shuld run forever");
			myoutput.append(resultIfApi);
			resultIfApi= myData.readLine();
			
		}
		System.out.println(myoutput);
		TestPOJO outputobject =objectMapper.readValue(myoutput.toString(), TestPOJO.class);
		System.out.println("value from oibject"+outputobject.getTestid());
		}
		else {
			
			System.out.println("bad status");
		}
		

		httpURLConnection.disconnect();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

public static void restTemplateDemo() {
	
	RestTemplate restTemplate = new RestTemplate();
 	//String data = restTemplate.getForObject("http://localhost:8080/spring-rest/jsontest?testinput=dummy", String.class);
	TestPOJO testPOJO = new TestPOJO("newName", "newtestId");
HttpEntity<TestPOJO> httpEntity = new HttpEntity<TestPOJO>(testPOJO);

ResponseEntity<TestPOJO> responseEnity =restTemplate.exchange("http://localhost:8080/spring-rest/jsontestwithjsonbody", HttpMethod.POST,httpEntity, TestPOJO.class);
	
 	System.out.println("output");
	//System.out.println(data);
	System.out.println(responseEnity.getStatusCode());
	System.out.println(responseEnity.getBody().getTestid());
	System.out.println(responseEnity.getBody().getTestname());
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
