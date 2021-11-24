package com.demo.spring;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmpServiceApplicationTests {

	@Autowired
	TestRestTemplate rt;
	
	@MockBean
	EmpRepository repo;
	
	@Test
	public void testDemoController() {
		String resp=rt.getForObject("/greet", String.class);
		Assertions.assertTrue(resp.contains("REST"));
	}
	
	@Test
	public void testEmpRestController() {
		when(repo.findById(104)).thenReturn(Optional.of(new Emp(104, "Ajay", "", 1.0)));
		
		String resp=rt.getForObject("/emp/find/104", String.class);
		Assertions.assertTrue(resp.contains("Ajay"));
	}

}
