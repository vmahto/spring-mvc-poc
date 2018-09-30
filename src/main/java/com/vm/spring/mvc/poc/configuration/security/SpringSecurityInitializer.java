package com.vm.spring.mvc.poc.configuration.security;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
 * “SpringSecurityInitializer” is used to register 
 * the DelegatingFilterProxy to use  the springSecurityFilterChain. 
 * It avoids writing Filters configuration in web.xml file.
 * */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}