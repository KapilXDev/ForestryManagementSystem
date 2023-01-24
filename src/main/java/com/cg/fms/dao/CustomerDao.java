package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cg.fms.dto.Customer;
import com.cg.fms.dto.User;


public interface CustomerDao extends JpaRepository<Customer, Integer>{
	/*
	public boolean loginCustomer(String customerName, String customerPassword);

	public Customer findCustomer(int customerId);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	@Query("Delete from Customer a where a.customerId=customerId")
	public boolean deleteCustomer(int customerId);
	
	public List<Customer> findAllCustomers();*/
	
	//Optional<Customer> findByCustomerName(String customerName);

	//Boolean existsByCustomerName(String username);
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
}
