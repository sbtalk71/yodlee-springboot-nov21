package com.demo.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

	@Mock
	Message message;
	
	
	@InjectMocks
	Calculator cal=new Calculator();
	
	@Test
	public void testAdd() {
		when(cal.add(2, 4)).thenReturn(6);
		
		Assertions.assertEquals(6, cal.add(2, 4));
		verify(cal,atLeast(1)).add(2, 4);
	}
	
	@Test
	public void testInjectMock() {
		when(message.getMessage()).thenReturn("Hello Mocking World");
		
		System.out.println(cal.getMessage().getMessage());
	}
}
