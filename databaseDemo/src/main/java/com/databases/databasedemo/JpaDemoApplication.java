package com.databases.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databases.databasedemo.entity.Person;
import com.databases.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) { //try going to localhost:8080/h2-console/
											 //JDBC URL must be jdbc:h2:mem:testdb (refer to application.properties)
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("\nUser id 10001 -> {}", repository.findById(10001));
		logger.info("\nInserting new user...", repository.insert(new Person("Tara", "Berlin", new Date())));
		logger.info("\nUpdating user id 5 if it exists... (hint: it doesn't) -> {}", repository.update(5,new Person("Blah", "New Location", new Date())));
		logger.info("\nUpdating user id 1 if it exists... (hint: it does!) -> {}", repository.update(1,new Person("UpdateName", "UpdatedLocation", new Date())));
		
		logger.info("\nDeleting id 5.... but it doesn't exist so nothing happens");
		repository.deleteById(5);
		logger.info("\nDeleting id 10002.... it exists so now it disappears...");
		repository.deleteById(10002);
		logger.info("\nAll users -> {}", repository.findAll());
	
	}

}
