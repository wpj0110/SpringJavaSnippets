package com.databases.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databases.databasedemo.entity.Person;
import com.databases.databasedemo.springdata.PersonSpringDataRepository;

//this class uses the JpaRepository (as autowired within PersonSpringDataRepository)
@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository repository;
	
	public static void main(String[] args) { //try going to localhost:8080/h2-console/
											 //JDBC URL must be jdbc:h2:mem:testdb (refer to application.properties)
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		//just use the "save" method instead
		logger.info("\nUser id 10001 -> {}", repository.findById(10001));
		logger.info("\nInserting new user...", repository.save(new Person("Tara", "Berlin", new Date())));
		logger.info("\nInserting new user... -> {}", repository.save(new Person("Blah", "New Location", new Date())));
		logger.info("\nInserting new user... -> {}", repository.save(new Person("UpdateName", "UpdatedLocation", new Date())));

		logger.info("\nAll users -> {}", repository.findAll());
	
	}

}
