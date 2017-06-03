package com.amuos.service.impl;

public class  PersonServiceBeanFactory {
	//Instantiation using a static factory method
	public static PersonServiceBean createPersonServiceBean(){
		return new PersonServiceBean();
	}
	//Instantiation using an instance factory method, no static keyword
	public PersonServiceBean createPersonServiceBean2(){
		return new PersonServiceBean();
	}
}
