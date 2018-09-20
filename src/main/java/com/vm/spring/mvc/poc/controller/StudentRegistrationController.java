package com.vm.spring.mvc.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vm.spring.mvc.poc.model.Student;
import com.vm.spring.mvc.poc.service.IStudentSvc;

@Controller
public class StudentRegistrationController {

	@Autowired
	private IStudentSvc studentSvc;
	
	@RequestMapping(value = {"/showStudnets", "/addStudent/showStudents"})
	public void multiMappingMethod() {
		
		displayStudent();
	}
	
	/*@RequestMapping(value = "/addStudent")
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
	}*/
	/*
	 * Using @ModelAttribute to bind all model attribute.
	 * */
	/*@RequestMapping(value = "/addStudent")
	public ModelAndView addStudent(@ModelAttribute Student student, BindingResult bindingResult) {
	
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()) {
			
			modelAndView.addObject(bindingResult.getFieldError());
			modelAndView.setViewName("studentAddError");
			
		} else {
			
			modelAndView.addObject(student);
			modelAndView.setViewName("studentAddSuccess");
		}
		
		return modelAndView;
	}*/
	
	public void setStudnetSvc(IStudentSvc studnetSvc) {
		this.studentSvc = studnetSvc;
	}

	@RequestMapping(value = "/addStudent")
	public ModelAndView addStudent(@ModelAttribute("student") Student student) {
	
		studentSvc.addStudent(student);
		
		displayStudent();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("studentAddSuccess");
		
		return modelAndView;
	}
	
	private void displayStudent(){
		System.out.println(" ********************All Students  *********************");
		
		studentSvc.getStudentList().forEach(student -> System.out.print(student));
		/*for (Student student : studentSvc.getStudentList()) {
			System.out.println(student);
		}*/
		System.out.println(studentSvc.getStudentList());
		
		System.out.println("*******************************************");
	}
	/*
	 * When each handler call in your Controller class needs the
	 * same common information adding to the model for every page request.
	 * We may require to get some dto from service then transfer it to view 
	 * for every request. Here It automatically add  this dto to Model object.
	 * */
	@ModelAttribute("student")
	  public Student populateUser() {
		Student student = new Student();
		student.setFname("Test");
	    return student;
	  }
}
