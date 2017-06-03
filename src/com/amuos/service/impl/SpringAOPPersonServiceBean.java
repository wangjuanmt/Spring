package com.amuos.service.impl;

import com.amuos.service.SpringAOPPersonService;

public class SpringAOPPersonServiceBean implements SpringAOPPersonService {
	private String userName;

	public String getUserName() {
		return userName;
	}


	public void save(String name) {
		System.out.println("this is save method");
//		throw new RuntimeException("我爱例外");		
	}


	public void update(String name, Integer personid) {
		System.out.println("this is update method");
	}


	public String getPersonName(Integer personid) {
		System.out.println("this is getPersonName method");
		return "xxx";
	}

}
