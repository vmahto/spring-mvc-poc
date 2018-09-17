package com.vm.spring.mvc.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentRegisterationController {

	@RequestMapping(value = "/hii")
	public String sayHello() {
		System.out.println("hii in controller");
		return "Heloo from Controller";
	}
}
