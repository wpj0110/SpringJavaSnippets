package com.databases.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.databases.databasedemo.entity.Person;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {

	//connect to the database
	@PersistenceContext
	EntityManager entityManager; //EntityManager is the interface to the persistence context.
	
	public List<Person> findAll() { //this is using jpql
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(int id, Person newPerson) { //HOW DO YOU UPDATE!!!! maybe this is the soluation? https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa
		Person person = findById(id);
		if (person != null) {
			person.setName(newPerson.getName());
			person.setLocation(newPerson.getLocation());
			person.setBirthDate(newPerson.getBirthDate());
			return entityManager.merge(person);
		}
		return entityManager.merge(newPerson); //merge will insert a new row if the id doesn't exist. Otherwise, it will update the existing id.
	}
	
	public Person insert(Person person) { 
		return entityManager.merge(person); 
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		if (person != null) {
			entityManager.remove(person);
		}
	}
}
