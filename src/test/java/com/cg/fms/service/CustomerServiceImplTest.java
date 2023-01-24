package com.cg.fms.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Land;
import com.cg.fms.dto.User;
@SpringBootTest
class CustomerServiceImplTest {
@Autowired
CustomerServiceImpl customerService;
@MockBean
CustomerDao repo;

	@Test
	void testServiceGetCustomer() throws Exception {
		Customer c=new Customer();
		c.setId(1);
		c.setCustomerAddress("address");
		c.setCustomerContact("1542012345");
		c.setCustomerEmail("mail@gmail.com");
		c.setUsername("name");
		c.setPassword("xxxx");
		c.setCustomerPostalCode("code");
		c.setCustomerTown("town");
		Optional<Customer> c1=Optional.of(c);
		Mockito.when(repo.findById(1)).thenReturn(c1);
		assertThat(customerService.serviceGetCustomer(1)).isEqualTo(c);

	}

	@Test
	void testServiceAddCustomer() {
		Customer c=new Customer();
		c.setId(1);
		c.setCustomerAddress("address");
		c.setCustomerContact("1542012345");
		c.setCustomerEmail("mail@gmail.com");
		c.setUsername("name");
		c.setPassword("xxxx");
		c.setCustomerPostalCode("code");
		c.setCustomerTown("town");
		Mockito.when(repo.save(c)).thenReturn(c);
		assertThat(customerService.serviceAddCustomer(c)).isEqualTo("added");
		
	}

	@Test
	void testServiceUpdateCustomer() throws Exception {
		Customer c=new Customer();
		c.setId(1);
		c.setCustomerAddress("address");
		c.setCustomerContact("1542012345");
		c.setCustomerEmail("mail@gmail.com");
		c.setUsername("name");
		c.setPassword("xxxx");
		c.setCustomerPostalCode("code");
		c.setCustomerTown("town");
		Optional<Customer> c1=Optional.of(c);
		Mockito.when(repo.findById(1)).thenReturn(c1);
		Mockito.when(repo.save(c)).thenReturn(c);	
		c.setCustomerAddress("new address");
		c.setCustomerContact("91542012345");
		c.setCustomerEmail("newmail@gmail.com");
		c.setUsername("new name");
		c.setPassword("new xxxx");
		c.setCustomerPostalCode("new code");
		c.setCustomerTown("new town");			
		assertThat(customerService.serviceUpdateCustomer(c)).isEqualTo("updated");

	}

	@Test
	void testServiceDeleteCustomer() {
		Customer c=new Customer();
		c.setId(1);
		c.setCustomerAddress("address");
		c.setCustomerContact("1542012345");
		c.setCustomerEmail("mail@gmail.com");
		c.setUsername("name");
		c.setPassword("xxxx");
		c.setCustomerPostalCode("code");
		c.setCustomerTown("town");
		Optional<Customer> c1=Optional.of(c);
		Mockito.when(repo.findById(1)).thenReturn(c1);
		Mockito.when(repo.existsById(c.getId())).thenReturn(false);
		assertFalse(repo.existsById(c.getId()));
		
	}

	@Test
	void testServiceGetAllCustomers() {
		Customer c=new Customer();
		c.setId(1);
		c.setCustomerAddress("address");
		c.setCustomerContact("1542012345");
		c.setCustomerEmail("mail@gmail.com");
		c.setUsername("name");
		c.setPassword("xxxx");
		c.setCustomerPostalCode("code");
		c.setCustomerTown("town");
		Customer c1=new Customer();
		c.setId(1);
		c.setCustomerAddress("address2");
		c.setCustomerContact("15420123452");
		c.setCustomerEmail("mail2@gmail.com");
		c.setUsername("name2");
		c.setPassword("xxxx2");
		c.setCustomerPostalCode("code2");
		c.setCustomerTown("town2");
		List<Customer> ca=new ArrayList<>();
		ca.add(c); 	ca.add(c1);
		
		Mockito.when(repo.findAll()).thenReturn(ca);
		assertThat(customerService.serviceGetAllCustomers()).isEqualTo(ca);
		
	}

}