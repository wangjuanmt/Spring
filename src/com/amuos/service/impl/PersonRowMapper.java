package com.amuos.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amuos.bean.Person;

public class PersonRowMapper implements RowMapper {

	//if(rs.next)
	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Person person = new Person(rs.getString("name"));
		person.setId(rs.getInt("id"));
		return person;
	}

}
