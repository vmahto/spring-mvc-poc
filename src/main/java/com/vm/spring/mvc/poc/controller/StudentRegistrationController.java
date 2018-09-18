package com.vm.spring.mvc.poc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vm.spring.mvc.poc.model.Student;

@Controller
public class StudentRegistrationController {

	@RequestMapping(value = "/addStudent")
	public ModelAndView addStudent(HttpServletRequest request, HttpServletResponse response) {
	
		Student student = new Student();
		student.setFname(request.getParameter("first_name"));
		student.setLname(request.getParameter("last_name"));
		student.setUsername(request.getParameter("username"));
		student.setPassword(request.getParameter("password"));
		student.setAddress(request.getParameter("address"));
		student.setContactNo(request.getParameter("contactNo"));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(student);
		modelAndView.setViewName("studentAddSuccess");
		return modelAndView;
	}
	
}
