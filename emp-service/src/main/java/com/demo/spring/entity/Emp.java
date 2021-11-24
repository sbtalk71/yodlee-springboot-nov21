package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name="EMP")
@XmlRootElement
public class Emp /*extends RepresentationModel<Emp>*/{
	@Id
	@Column(name="EMPNO")
	@NotNull
	private Integer empId;
	
	private String name;
	
	@Column(name="ADDRESS")
	private String city;
	
	private double salary;

	public Emp() {
		
	}

	public Integer getEmpId() {
		
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		
		this.salary = salary;
	}

	public Emp(Integer empId, String name, String city, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		
		return empId+" "+name+" "+city+" "+salary;
	}

	
}
