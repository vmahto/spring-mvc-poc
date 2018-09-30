package com.vm.spring.mvc.poc.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class MySingletonScopeBean {

	public void showMessage(){
        MyPrototypeBean bean = getPrototypeBean();
        System.out.println("Hi, the time is "+bean.getDateTime());
    }

    @Lookup
    public MyPrototypeBean getPrototypeBean(){
        //spring will override this method
        return null;
    }
	
}
