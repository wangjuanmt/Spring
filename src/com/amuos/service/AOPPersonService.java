package com.amuos.service;


public interface AOPPersonService {

	public String getUser();
	public void save(String name);
	public void update(String name, Integer personid);
	public String getPersonName(Integer personid);

}