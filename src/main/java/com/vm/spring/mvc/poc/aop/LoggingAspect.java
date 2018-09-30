package com.vm.spring.mvc.poc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {

	@Before("execution(public String getName())")
	public void llogingAspect(){
		
		System.out.println("Logging Startated *****************");
		System.out.println("Executing Advice on getName()");
	}
	@Before("execution(* com.vm.spring.mvc.poc.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("$$$$$$$$$$$Service method All called $$$$$$$$$$$");
	}
	
	@Before("execution(public * com.vm.spring.mvc.poc.*.*.*Student*())")
	public void genralAspect(){
		
		System.out.println("genralAspect Logging Startated *****************");
		System.out.println("Executing Advice on get*()");
	}
}
