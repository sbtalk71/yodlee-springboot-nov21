package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	@Query("select e from Emp as e where e.salary between ?1 and ?2")
	public List<Emp> getAllBetweenSalary(double low, double hi);
}
