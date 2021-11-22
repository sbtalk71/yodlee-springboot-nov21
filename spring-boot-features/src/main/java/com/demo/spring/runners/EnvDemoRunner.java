package com.demo.spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Component
@EnableConfigurationProperties
@PropertySource("classpath:myconfig/app.properties")
public class EnvDemoRunner implements CommandLineRunner {

	@Autowired
	Environment env;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Name is "+env.getProperty("ds.user_name"));
		System.out.println(env);

	}

}
