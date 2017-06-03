package com.amuos.service.impl;

import com.amuos.service.AOPPersonService;

public class AOPPersonServiceBean implements AOPPersonService {
	private String user = null;

	public String getUser() {
		return user;
	}

	public AOPPersonServiceBean(){}
	
	public AOPPersonServiceBean(String user) {
		this.user = user;
	}

	public void save(String name) {
		System.out.println("this is save() method");
	}

	public void update(String name, Integer personid) {
		System.out.println("this is update() method");
	}

	public String getPersonName(Integer personid) {
		System.out.println("this is getPersonName() method");
		return "xxx";
	}

}
