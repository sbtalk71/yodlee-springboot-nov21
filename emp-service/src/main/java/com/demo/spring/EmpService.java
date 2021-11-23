package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repo.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository repo;

	public Emp findEmp(int id) throws EmpNotFoundException {
		Optional<Emp> OptEmp = repo.findById(id);
		if (OptEmp.isPresent()) {
			return OptEmp.get();
		} else {
			throw new EmpNotFoundException();
		}

	}

	public List<Emp> listAll() {
		return repo.findAll();
	}

	public String saveEmp(Emp e) {
		if (repo.existsById(e.getEmpId())) {
			return "Emp Already exists";
		} else {
			repo.save(e);
			return "Emp Saved successfully";
		}
	}
}
