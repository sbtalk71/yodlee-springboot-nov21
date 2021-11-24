package com.demo.spring.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.spring.entity.Emp;

@RepositoryRestResource(path = "data-rest")
public interface EmpRestDataRepository extends PagingAndSortingRepository<Emp, Integer>{

}
