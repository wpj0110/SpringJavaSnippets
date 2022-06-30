package com.databases.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databases.databasedemo.entity.Person;
import com.databases.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication //I want to use the JpaDemoApplication so I will comment this one for now.
public class SpringJdbcDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) { //try going to localhost:8080/h2-console/
											 //JDBC URL must be jdbc:h2:mem:testdb (refer to application.properties)
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		//The following below is for the JDBC example
		/*
		logger.info("\nAll users -> {}", dao.findAll());
		logger.info("\nUser id 10001 -> {}",dao.findById(10001));
		logger.info("\nUser with the name: Pieter is: -> {}", dao.findByName("Pieter"));
		logger.info("\nDeleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10002));
		logger.info("\nInserting 10004 -> {}", dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("\nUpdating 10004 -> {}", dao.update(new Person(10003, "New Name", "Place Here", new Date())));
		 */

	
	}

}
