package com.demo.spring.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class EmpDaoMySQLImpl implements EmpDao {

	@Override
	public String findEmp(int id) {
		System.out.println("MYSQL impl");
		return "Emp Found with id "+ id;
	}

}
