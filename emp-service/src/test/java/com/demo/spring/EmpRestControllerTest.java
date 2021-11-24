package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmpRestControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	EmpRepository repo;
	
	@MockBean
	EmpService service;
	
	@Autowired
	@InjectMocks
	EmpService service1;

	
	
	@Test
	public void testFindEmpWithId() throws Exception {
		when(service.findEmp(104)).thenReturn(new Emp(104, "Ajay", "", 1.0));
		//when(repo.findById(104)).thenReturn(Optional.of(new Emp(104, "Ajay", "", 1.0)));
		
		mvc
		.perform(get("/emp/find/104"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(Matchers.containsString("Ajay")))
		.andDo(print());
	}
	
	@Test
	@Disabled
	public void testFindEmpWithIdAsJSON() throws Exception {
		when(service.findEmp(104)).thenReturn(new Emp(104, "Ajay", "", 1.0));
		//when(repo.findById(104)).thenReturn(Optional.of(new Emp(104, "Ajay", "", 1.0)));
		
		mvc
		.perform(get("/emp/find/104"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.name").value("Ajay"))
		.andExpect(jsonPath("$.salary").value(1.0))
		.andDo(print());
	}
	
	@Test
	public void testServiceForFinder() throws Exception {
		when(service.findEmp(104)).thenReturn(new Emp(104, "Ajay", "", 1.0));
		
		System.out.println(service.findEmp(104));
		Assertions.assertTrue(service.findEmp(104).getName().contains("Ajay"));
	}
}
