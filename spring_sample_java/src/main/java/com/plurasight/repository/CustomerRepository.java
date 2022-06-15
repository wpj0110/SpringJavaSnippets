package com.plurasight.repository;

import java.util.List;

import com.plurasight.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}