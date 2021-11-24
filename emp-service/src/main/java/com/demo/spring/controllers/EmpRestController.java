package com.demo.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpService;
import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpNotFoundException;

@RestController
@RequestMapping("emp")
public class EmpRestController {

	@Autowired
	EmpService service;

	@GetMapping(path="find/{empId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@Cacheable(cacheNames = "empFindCache")
	public ResponseEntity findEmp(@PathVariable("empId") int id) {
		Emp emp = null;
		try {
			emp = service.findEmp(id);
		} catch (EmpNotFoundException e) {
			return ResponseEntity.status(404).body("Emp Not Found");
		}
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping(path="save",produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createEmp(@RequestBody @Valid Emp e){
		String response=service.saveEmp(e);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping(produces = "application/json")
	@Cacheable(cacheNames = "empFindCache")
	public ResponseEntity<List<Emp>> getList(){
		return ResponseEntity.ok(service.listAll());
	}
}
