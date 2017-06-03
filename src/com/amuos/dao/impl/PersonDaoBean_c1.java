package com.amuos.dao.impl;

import com.amuos.dao.PersonDao;
import com.amuos.dao.PersonDao_c1;

public class PersonDaoBean_c1 implements PersonDao_c1 {
	/* (non-Javadoc)
	 * @see com.amuos.dao.impl.PersonDao#add()
	 */
	/* (non-Javadoc)
	 * @see com.amuos.dao.impl.PersonDao_c1#add()
	 */
	@Override
	public void add(){
		System.out.println("execute add() method in PersonDaoBean_c1");
	}
}
