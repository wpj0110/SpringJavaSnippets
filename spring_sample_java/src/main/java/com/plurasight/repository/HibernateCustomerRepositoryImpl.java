package com.plurasight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.plurasight.model.Customer;

@Repository("customerRepository") //this is bean named "customerRepository"
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${dbUsername}") //inject the value here
	private String dbUsername;
	
	@Override
	public List<Customer> findAll(){
		System.out.println("dbUsername is "+ dbUsername + "from 'app.properties'");
		
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan");
		customer.setLastname("Hansen");
		
		customers.add(customer);
		
		return customers;
	}
}
