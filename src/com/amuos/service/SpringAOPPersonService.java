package com.amuos.service;

public interface SpringAOPPersonService {
	public void save(String name);
	public void update(String name, Integer personid);
	public String getPersonName(Integer personid);
	public String getUserName();
}
