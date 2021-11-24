package com.demo.spring;

public class Calculator {

	public Message message;
	
	public void setMessage(Message message) {
		this.message = message;
	}

	
	public Message getMessage() {
		return message;
	}


	public int add(int a, int b) {
		System.out.println("add Called..");
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}
	
	
}
