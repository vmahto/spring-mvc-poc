package com.vm.spring.mvc.poc.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vm.spring.mvc.poc.beans.MySingletonScopeBean;
import com.vm.spring.mvc.poc.configuration.AppConfig;

public class SpringMain {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		MySingletonScopeBean bean = context.getBean(MySingletonScopeBean.class);
		bean.showMessage();
		Thread.sleep(1000);

		bean.showMessage();
		
		
		
	}

}
