package com.amuos.service;

import java.util.List;

import com.amuos.bean.Person;


public interface JdbcPersonService {
	/*
	 * 保存person
	 * param:person
	 */
	public void save(Person person);
	
	/*
	 * 更新person
	 * param:person
	 */
	public void update(Person person);
	
	/*
	 * 获取person
	 * param:personId
	 * return:Person
	 */
	public Person getPerson(Integer personId);
	
	/*
	 * 获取所有person
	 * return:Person集合
	 */
	public List<Person> getPersons();
	
	/*
	 * 删除person
	 * param:personId
	 */
	public void delete(Integer personId);
}
