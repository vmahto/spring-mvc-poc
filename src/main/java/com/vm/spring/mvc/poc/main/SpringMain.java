package com.vm.spring.mvc.poc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vm.spring.mvc.poc.configuration.HelloWorldInitializer;
import com.vm.spring.mvc.poc.service.StudentSvc;

public class SpringMain {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HelloWorldInitializer h = new HelloWorldInitializer(); 
//		StudentSvc employeeService = ctx.getBean("StudentSvc", StudentSvc.class);
		
//		System.out.println(employeeService.getStudentList());
		
				
//		ctx.close();
	}

}
