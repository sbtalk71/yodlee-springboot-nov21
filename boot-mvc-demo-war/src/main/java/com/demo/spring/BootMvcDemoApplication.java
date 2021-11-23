package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootMvcDemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BootMvcDemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("Servlet Initilizer called..");
		
		return builder.sources(BootMvcDemoApplication.class);
	}
}
