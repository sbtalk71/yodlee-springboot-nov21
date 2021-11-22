package com.demo.spring.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.DataSoureProperties;
import com.demo.spring.dao.EmpDao;

@Component
public class MyDemoRunner implements CommandLineRunner {

	@Autowired
	private EmpDao dao;
	
	@Value("${profile.name}")
	String profileName;
	
	@Value("${person.name}")
	String name;
	
	@Autowired
	DataSoureProperties ds;
	
	Logger LOGGER=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("You are using prifle "+profileName +" run by  "+name);
		LOGGER.info("JDBC URL "+ds.getUrl());
		LOGGER.info("JDBC User "+ds.getUserName());
		LOGGER.info(dao.findEmp(100));

	}

}
