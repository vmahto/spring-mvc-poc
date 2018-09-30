package com.vm.spring.mvc.poc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginnController {

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error){
		
		ModelAndView modelAndView = new ModelAndView();
		if(error != null){
			
			modelAndView.addObject("error","Invalid Login Credential");
		}
		modelAndView.setViewName("login");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/logout", method= RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse resp){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null){
			
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
		return "redirect:/login?logout";
	}
}
