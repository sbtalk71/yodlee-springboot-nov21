package com.demo.spring.runners;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class JPARunner implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void run(String... args) throws Exception {
		
		Emp emp=em.find(Emp.class, 104);
		System.out.println(emp);
	}

}
