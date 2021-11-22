package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties()

public class SpringBootFeaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFeaturesApplication.class, args);
	}

}
