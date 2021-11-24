package com.demo.spring.controllers;

import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
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

	@GetMapping(path="find/{empId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@Cacheable(cacheNames = "empFindCache")
	public ResponseEntity findEmp(@PathVariable("empId") int id) {
		Emp emp = null;
		try {
			emp = service.findEmp(id);
			emp.add(linkTo(methodOn(EmpRestController.class).findEmp(id)).withSelfRel(),
					linkTo(methodOn(EmpRestController.class).createEmp(emp)).withRel("create Emp"));
			
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
	//@Cacheable(cacheNames = "empFindCache")
	public ResponseEntity getList(){
		List<Emp> empList=service.listAll();
		
		for(Emp emp: empList) {
			emp.add(linkTo(methodOn(EmpRestController.class).findEmp(emp.getEmpId())).withSelfRel());
		}
		Link link=linkTo(methodOn(EmpRestController.class).getList()).withSelfRel();
		CollectionModel<Emp> result=CollectionModel.of(empList).add(link);
		
		return ResponseEntity.ok(result);
	}
}
