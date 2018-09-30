package com.vm.spring.mvc.poc.beans;

import java.util.Date;

public class MyPrototypeBean {
	 private String dateTimeString = new Date().toString();

	    public String getDateTime() {
	        return dateTimeString;
	    }
}
