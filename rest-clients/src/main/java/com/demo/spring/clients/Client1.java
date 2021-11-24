package com.demo.spring.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client1 {

	public static void main(String[] args) {
	
		RestTemplate rt= new RestTemplate();
		
		String response=rt.getForObject("http://localhost:8080/emp/find/104", String.class);
		System.out.println(response);
		
		//--------------//
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity req=new HttpEntity<>(headers);
		
		
		ResponseEntity<String> resp=rt.exchange("http://localhost:8080/emp/find/104", HttpMethod.GET, req, String.class);
		
		System.out.println(resp.getBody());
		

	}

}
