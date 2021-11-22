package com.demo.spring.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class EmpDaoOracleImpl implements EmpDao {

	@Override
	public String findEmp(int id) {
		System.out.println("Oracle impl");
		return "Emp Found with id "+ id;
	}

}
