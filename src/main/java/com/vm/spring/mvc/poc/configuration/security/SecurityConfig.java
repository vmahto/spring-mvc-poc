package com.vm.spring.mvc.poc.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authbuilder) throws Exception {
		
		authbuilder.inMemoryAuthentication().withUser("vmahto").password("123").roles("ADMIN");
//		authbuilder.inMemoryAuthentication().withUser("siju").password("123").roles("USER");
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().antMatchers("/login").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/studentregpage","/showStudnets","/deleteStudent").access("hasRole('ADMIN') or hasRole('USER')");
		
		httpSecurity.authorizeRequests().and().formLogin()
		.loginProcessingUrl("/j_spring_security_check")
		.loginPage("/login")
		.defaultSuccessUrl("/studentregpage")
		.failureUrl("/login?error=true")
		.usernameParameter("username")
		.passwordParameter("password");
		
	}
}
