package com.plurasight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.plurasight.model.Customer;
import com.plurasight.repository.CustomerRepository;

@Service("customerService") //this is a bean named "customerService"
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //@Scope("singleton") is also acceptable.
//Notice that because of this scope, the objects printed refer to the SAME reference.
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //@Scope("prototype") is also acceptable.
//Notice that because of this scope, the objects printed refer to a DIFFERENT reference.
public class CustomerServiceImpl implements CustomerService {
	
	//@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		
	}
	
	@Autowired //Try removing the comments and see what happens
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using constructor injection");
		this.customerRepository = customerRepository;
	}
	
	//@Autowired //Try removing the comments and see what happens
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using setter injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
