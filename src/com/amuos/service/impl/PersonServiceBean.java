package com.amuos.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.amuos.dao.PersonDao;
import com.amuos.service.PersonService;

public class PersonServiceBean implements PersonService {
	private PersonDao personDao;
	private String stringProperty;
	private Set<String> sets = new HashSet<String>();
	private List<String> lists = new ArrayList<String>();
	private Properties properties = new Properties();
	private Map<String, String> maps = new HashMap<String, String>();
	
	
	public Map<String, String> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public List<String> getLists() {
		return lists;
	}
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	public String getStringProperty() {
		return stringProperty;
	}
	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}

	public Set<String> getSets() {
		return sets;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void save(){
//		System.out.println("save() method");
		System.out.println(stringProperty);
		System.out.println(sets);
		personDao.add();
	}
	
//	public void init(){
//	System.out.println("init method");
//}
//
//public PersonServiceBean(){
//	System.out.println("This is construction.");
//}
//	public void destroy(){
//		System.out.println("destroy method");
//	}
}
