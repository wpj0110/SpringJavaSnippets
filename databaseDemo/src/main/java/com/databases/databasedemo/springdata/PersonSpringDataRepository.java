package com.databases.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.databases.databasedemo.entity.Person;

public interface PersonSpringDataRepository
	extends JpaRepository<Person, Integer>{

}
