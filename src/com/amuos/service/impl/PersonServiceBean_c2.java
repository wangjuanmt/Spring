package com.amuos.service.impl;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.amuos.dao.PersonDao_c2;
import com.amuos.service.PersonService_c2;


//@Service
//@Service("personServiceBean") @Scope("prototype")
@Service("personServiceBean")
public class PersonServiceBean_c2 implements PersonService_c2{
	private PersonDao_c2 personDao_c2;

	public void setPersonDao_c2(PersonDao_c2 personDao_c2) {
		this.personDao_c2 = personDao_c2;
	}
	
	//使用注解方法代替init-method
	@PostConstruct
	public void init(){
		System.out.println("init PersonServiceBean_c2");
	}
	
	//使用注解方法代替destroy-method
	@PreDestroy
	public void destroy(){
		System.out.println("close PersonServiceBean_c2");
	}

	public void save(){
		personDao_c2.add();
	}
	

}
