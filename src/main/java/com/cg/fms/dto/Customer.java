package com.cg.fms.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class Customer extends User{
	
	
	//@NotNull
	//@Column(name = "EMAIL")
	private String customerEmail;
	private String customerAddress;
	private String customerTown;
	//@NotNull
	private String customerPostalCode;
	//@NotNull
	//@Length(min = 10, max = 10,message="Please provide valid mobile no.")
	private String customerContact;
	
	public Customer() {
		
	}
	
	public Customer(String username, String password) {
		super(username, password);
		
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerTown() {
		return customerTown;
	}
	public void setCustomerTown(String customerTown) {
		this.customerTown = customerTown;
	}
	public String getCustomerPostalCode() {
		return customerPostalCode;
	}
	public void setCustomerPostalCode(String customerPostalCode) {
		this.customerPostalCode = customerPostalCode;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	
	

}
