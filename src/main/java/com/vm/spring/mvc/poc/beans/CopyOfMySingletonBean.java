/*package com.vm.spring.mvc.poc.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Component
public class CopyOfMySingletonBean implements ApplicationContextAware {

	@Autowired
	private MyPrototypeBean prototypeBean;
	private ApplicationContext applicationContext;


	public void showMessage() {

		System.out.println("Using applicationContextAware::"
				+ applicationContext.getBean(MyPrototypeBean.class)
						.getDateTime());
		System.out.println("Singleton Call, the time is "
				+ prototypeBean.getDateTime());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	
}
*/