package com.amuos.dao.impl;

import org.springframework.stereotype.Repository;

import com.amuos.dao.PersonDao;
import com.amuos.dao.PersonDao_c1;
import com.amuos.dao.PersonDao_c2;

@Repository
public class PersonDaoBean_c2 implements PersonDao_c2{

	@Override
	public void add(){
		System.out.println("execute add() method in PersonDaoBean_c2");
	}
}
