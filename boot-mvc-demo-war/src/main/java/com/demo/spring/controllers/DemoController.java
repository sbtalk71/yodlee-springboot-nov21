package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	@RequestMapping(path="/test",method = RequestMethod.GET)
	public String getPage() {
		System.out.println(this.getClass().getName()+" called..");
		return "demo";
	}
}
