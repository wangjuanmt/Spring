package com.amuos.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amuos.dao.PersonDao_c1;
import com.amuos.service.PersonService_c1;

public class PersonServiceBean_c1 implements PersonService_c1 {
	@Resource private PersonDao_c1 personDao_c1;
	private String name;
	
	//使用@Resource注解方式注入，须添加默认构造器
	public PersonServiceBean_c1(){};
	public PersonServiceBean_c1(PersonDao_c1 personDao_c1, String name) {
		this.personDao_c1 = personDao_c1;
		this.name = name;
	}

	public void save(){
		personDao_c1.add();
//		System.out.println(name);
	}
	
}
