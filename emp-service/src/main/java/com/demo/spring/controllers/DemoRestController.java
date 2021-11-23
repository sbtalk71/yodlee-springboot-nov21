package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("request")
public class DemoRestController {
	
	public DemoRestController() {
		System.out.println("Object created for "+this.getClass().getName());
	}

	@RequestMapping(path="/greet",method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getGreet() {
		return ResponseEntity.ok("Welcome to REST Application");
	}
	
	
}
