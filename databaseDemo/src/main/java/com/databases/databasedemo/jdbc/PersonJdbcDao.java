package com.databases.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.databases.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	//to talk to the database using jdbc... use JdbcTemplate
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	//select * from person
	public List<Person> findAll() {
		return jdbcTemplate.query("SELECT * FROM person",
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		//old way of doing... below
		//return jdbcTemplate.queryForObject("SELECT * FROM person where id=?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
		//new way of doing... below https://stackoverflow.com/questions/65301011/jdbctemplate-queryforobject-and-query-is-deprecated-in-spring-what-should-i
		//instead of the one below... use the mapper made from above
		//return jdbcTemplate.queryForObject("SELECT * FROM person where id=?", new BeanPropertyRowMapper<Person>(Person.class), id);
		return jdbcTemplate.queryForObject("SELECT * FROM person where id=?", new PersonRowMapper(), id);
	}
	
	public Person findByName(String name) {
		//old way of doing... below
		//return jdbcTemplate.queryForObject("SELECT * FROM person where id=?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
		//new way of doing... below
		return jdbcTemplate.queryForObject("SELECT * FROM person where name=?", new PersonRowMapper(), name);
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM person WHERE id=?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update("INSERT INTO person (id, name, location, birth_date) "
					+ "VALUES(?, ?, ?, ?)", 
					new Object[] { 
						person.getId(), 
						person.getName(), 
						person.getLocation(), 
						new Timestamp(person.getBirthDate().getTime()) 
						});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("UPDATE person SET name = ?, location = ?, birth_date = ? "
						+ "WHERE id = ?", 
						new Object[] { 
								person.getName(), 
								person.getLocation(), 
								new Timestamp(person.getBirthDate().getTime()),
								person.getId()
								});
	}
}
