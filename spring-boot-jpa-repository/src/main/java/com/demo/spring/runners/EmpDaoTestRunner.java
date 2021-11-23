package com.demo.spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.repo.EmpRepository;

@Component
public class EmpDaoTestRunner implements CommandLineRunner {

	@Autowired
	private EmpRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Emp emp = new Emp(107,"Raju","Hyderabad",50000);
		//String response=dao.save(emp);
		//System.out.println(response);
		System.out.println(dao.getClass().getName());
		
		dao.findAll().forEach(System.out::println);
		
	System.out.println("====Custom Query Result======");
	dao.getAllBetweenSalary(60000, 90000).forEach(System.out::println);

	}

}
