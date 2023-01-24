package com.cg.fms.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.advices.ResourceNotFoundException;
import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao repo;
	
	@Override
	public Customer serviceGetCustomer(int customerId) throws Exception {
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Customer not present in the database");
		return repo.findById(customerId).orElseThrow(s1);
		
	}

	@Override
	public Customer serviceAddCustomer(Customer customer) {
			repo.save(customer);
			return customer;
	}

	@Override
	public Customer serviceUpdateCustomer(Customer customer) throws Exception {
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Customer not present in the database");
		Customer c=repo.findById(customer.getId()).orElseThrow(s1);
		repo.save(customer);
			return customer;
		
	}

	@Override
	public Customer serviceDeleteCustomer(int customerId) throws Exception {
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Customer not present in the database");
		Customer c=repo.findById(customerId).orElseThrow(s1);
		repo.delete(c);
			return c;
	}

	@Override
	public List<Customer> serviceGetAllCustomers() {
		return repo.findAll();
	}
	

}
