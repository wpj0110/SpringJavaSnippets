package com.databases.databasedemo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity //for JPA. This will trigger a "Schema Update", and which means I won't have to create a table in my .sql file
//@Table(name="person") //for JPA, I could name it as "person" to know where it maps to, but I could just default it to the name of the class "Person". This section is commented.
@NamedQuery(name="find_all_persons", query="select p from Person p") //Person is referring to the entity "Person"
public class Person {
	
	//@Column is also optional, but everything matches so we don't really need it.
	
	//every time we create a new row, we want hibernate to make an Id for me
	@Id  // On the Id column, we made it a primary key by doing this
	@GeneratedValue //Typically, what hibernate does is it creates a sequence in the database and it uses this sequence to populate the value for this specific id
	private int id;
	
	private String name;
	private String location;
	
	public Person() { //needs a no argument default constructor. //This no argument default constructor is ALSO needed for hibernate
		
	}
	
	public Person(String name, String location, Date birthDate) { //This is for JPA Hibernate. Hibernate will assign the "id" value for us.
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	/*
	public Person(int id, String name, String location, Date birthDate) { //This is for JDBC
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	private Date birthDate;

	@Override
	public String toString() { //notice that this prints 3 lines of the Person
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	
	

}
