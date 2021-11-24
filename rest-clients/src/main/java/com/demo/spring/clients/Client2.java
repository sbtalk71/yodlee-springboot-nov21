package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class Client2 {

	public static void main(String[] args) {
	
		RestTemplate rt= new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE);
		
		Emp emp = new Emp(110, "James", "Hyderabad", 90000);
		
		HttpEntity req=new HttpEntity<>(emp,headers);
		
		
		ResponseEntity<String> resp=rt.exchange("http://localhost:8080/emp/save", HttpMethod.POST, req, String.class);
		
		System.out.println(resp.getBody());
		

	}

}
