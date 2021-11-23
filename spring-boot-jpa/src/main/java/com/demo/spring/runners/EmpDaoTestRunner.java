package com.demo.spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.dao.EmpDao;

@Component
public class EmpDaoTestRunner implements CommandLineRunner {

	@Autowired
	private EmpDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Emp emp = new Emp(107,"Raju","Hyderabad",50000);
		//String response=dao.save(emp);
		//System.out.println(response);
		
		dao.listAll().forEach(System.out::println);

	}

}
