package com.amuos.dao.impl;

import com.amuos.dao.PersonDao;

public class PersonDaoBean implements PersonDao {
	/* (non-Javadoc)
	 * @see com.amuos.dao.impl.PersonDao#add()
	 */
	@Override
	public void add(){
		System.out.println("execute add() method in PersonDaoBean");
	}
}
