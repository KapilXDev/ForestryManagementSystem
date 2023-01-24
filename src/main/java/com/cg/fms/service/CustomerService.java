package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Customer;

public interface CustomerService {
	
	public Customer serviceGetCustomer(int customerId) throws Exception;

	public Customer serviceAddCustomer(Customer customer);

	public Customer serviceUpdateCustomer(Customer customer) throws Exception;

	public Customer serviceDeleteCustomer(int customerId) throws Exception;

	public List<Customer> serviceGetAllCustomers();
}
