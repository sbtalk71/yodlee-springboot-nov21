package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {

	public Emp findEmpById(Integer id);
	public String save(Emp e);
	public String update(Emp e);
	public String delete(int id);
	public List<Emp> listAll();
}
