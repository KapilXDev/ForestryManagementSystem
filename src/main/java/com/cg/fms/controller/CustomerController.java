package com.cg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Customer;
import com.cg.fms.service.CustomerServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerservice;
	@PostMapping("/addCustomer")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> addCustomer(@RequestBody @Valid Customer customer){
		Customer a=customerservice.serviceAddCustomer(customer);
		ResponseEntity r=new ResponseEntity<Customer>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody @Valid Customer customer) {
		Customer a;
		try {
			a = customerservice.serviceUpdateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = customerservice.serviceAddCustomer(customer);
		}
		ResponseEntity r=new ResponseEntity<Customer>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) throws Exception{
		Customer a=customerservice.serviceGetCustomer(id);
		ResponseEntity r=new ResponseEntity<Customer>(a, HttpStatus.OK);
		return r;
	}
	
	@GetMapping("/getAllCustomers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> a=customerservice.serviceGetAllCustomers();
		ResponseEntity<List<Customer>> r=new ResponseEntity<List<Customer>>(a, HttpStatus.OK);
		return r;
	}
	
	
	
	@DeleteMapping("/deleteCustomer/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws Exception{
		Customer a=customerservice.serviceDeleteCustomer(id);
		ResponseEntity r=new ResponseEntity<Customer>(a, HttpStatus.OK);
		return r;
		
	}
	
}
