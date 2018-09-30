package com.vm.spring.mvc.poc.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.vm.spring.mvc.poc.beans.MyPrototypeBean;
import com.vm.spring.mvc.poc.beans.MySingletonScopeBean;

@Configuration
@ComponentScan(basePackageClasses = MySingletonScopeBean.class)
public class AppConfig {

	 	@Bean
	    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	    public MyPrototypeBean prototypeBean () {
	        return new MyPrototypeBean();
	    }

	 /*   @Bean
	    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	    public MySingletonScopeBean singletonScopeBean() {
	        return new MySingletonScopeBean();
	    }*/
	    
	   
	   
}