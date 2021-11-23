package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="EMP")
@XmlRootElement
public class Emp {
	@Id
	@Column(name="EMPNO")
	@NotNull
	private Integer empId;
	
	private String name;
	
	@Column(name="ADDRESS")
	private String city;
	
	private double salary;

	public Emp() {
		System.out.println("Emp Object created..");
	}

	public Integer getEmpId() {
		System.out.println("setter called for empId..");
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setter called for name..");
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		System.out.println("setter called for city..");
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		System.out.println("setter called for salary..");
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