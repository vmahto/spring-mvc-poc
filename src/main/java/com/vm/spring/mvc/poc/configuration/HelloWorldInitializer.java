package com.vm.spring.mvc.poc.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.vm.spring.mvc.poc.configuration.security.SecurityConfig;
import com.vm.spring.mvc.poc.main.SpringApplicationContext;

public class HelloWorldInitializer implements WebApplicationInitializer {

	public SpringApplicationContext applicationContext = new SpringApplicationContext(); 
	
	public void onStartup(ServletContext container) throws ServletException {

		System.out.println("onStart method Calldes");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(HelloWorldConfiguration.class);
		ctx.register(SecurityConfig.class);
		
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		applicationContext.setApplicationContext(ctx);
	}

}
