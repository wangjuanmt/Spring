package com.amuos.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.amuos.bean.Person;
import com.amuos.service.JdbcPersonService;

public class JdbcPersonServiceBean implements JdbcPersonService {
	private DataSource dataSource;
	//不直接操作DataSource，而操作JdbcTemplate
	private JdbcTemplate jdbcTemplate;
	

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Person person) {
		jdbcTemplate.update("insert into person(name) values (?)", new Object[]{person.getName()}, new int[]{java.sql.Types.VARCHAR});
	}

	@Override
	public void update(Person person) {
		jdbcTemplate.update("update person set name=? where id=?", new Object[]{person.getName(),person.getId()}, new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});
	}

	@Override
	public Person getPerson(Integer personId) {
		Person person = (Person)jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{personId}, new int[]{java.sql.Types.INTEGER}, new PersonRowMapper());
		return person;
	}

	@Override
	public List<Person> getPersons() {
		return (List<Person>) jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	/*
	 * JdbcPersonServiceBean使用@Transactional标记事务之后
	 * 如果抛出例外，操作没有成功，自动回滚。
	 * 删除不成功。
	 */
	@Override
	public void delete(Integer personId) {
		jdbcTemplate.update("delete from person where id=?", new Object[]{personId}, new int[]{java.sql.Types.INTEGER});
//		throw new RuntimeException("Runtime Exception!");
	}

}
