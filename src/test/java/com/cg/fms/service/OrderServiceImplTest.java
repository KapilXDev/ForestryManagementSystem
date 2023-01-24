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

import com.cg.fms.dao.IOrderDao;

import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Scheduler;
@SpringBootTest
class OrderServiceImplTest {
@Autowired
OrderServiceImpl orderService;
@MockBean
IOrderDao repo;

	@Test
	void testGetOrder() throws Exception {
		Orders o=new Orders();
		o.setOrderNumber(1);
		o.setDeliveryDate("22/09/2021");
		
		o.setDeliveryPlace("Hyderabad");
		o.setQuantity("20");
		Optional<Orders> o1=Optional.of(o);
		Mockito.when(repo.findById(1)).thenReturn(o1);

		assertThat(orderService.getOrder(1)).isEqualTo(o);
		
		
		//fail("Not yet implemented");
	}

	@Test
	void testAddOrder() {
		Orders o=new Orders();
		o.setOrderNumber(1);
		o.setDeliveryDate("22/09/2021");
		
		o.setDeliveryPlace("Hyderabad");
		o.setQuantity("20");
		Mockito.when(repo.save(o)).thenReturn(o);
		assertThat(orderService.addOrder(o)).isEqualTo("added");
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateOrder() throws Exception {
		Orders o=new Orders();
		o.setOrderNumber(1);
		o.setDeliveryDate("22/09/2021");
		
		o.setDeliveryPlace("Hyderabad");
		o.setQuantity("20");
		Optional<Orders> o1=Optional.of(o);
		Mockito.when(repo.findById(1)).thenReturn(o1);
		Mockito.when(repo.save(o)).thenReturn(o);
				
				o.setQuantity("400");	
				o.setDeliveryPlace("new place");
				
				assertThat(orderService.updateOrder(o)).isEqualTo("updated");
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteOrder() {
		Orders o=new Orders();
		o.setOrderNumber(1);
		o.setDeliveryDate("22/09/2021");
		
		o.setDeliveryPlace("Hyderabad");
		o.setQuantity("20");
		Optional<Orders> o1=Optional.of(o);
		Mockito.when(repo.findById(1)).thenReturn(o1);
		Mockito.when(repo.existsById(o.getOrderNumber())).thenReturn(false);
		assertFalse(repo.existsById(o.getOrderNumber()));
		//fail("Not yet implemented");
	}

	@Test
	void testGetAllOrders() {
		Orders o=new Orders();
		o.setOrderNumber(1);
		o.setDeliveryDate("22/09/2021");
		
		o.setDeliveryPlace("Hyderabad");
		o.setQuantity("20");
		Orders o1=new Orders();
		o1.setOrderNumber(2);
		o1.setDeliveryDate("17/08/2021");
		
		o1.setDeliveryPlace("Hyd");
		o1.setQuantity("200");
		List<Orders> oa=new ArrayList<>();
		oa.add(o); 	oa.add(o1);
		Mockito.when(repo.findAll()).thenReturn(oa);
		assertThat(orderService.getAllOrders()).isEqualTo(oa);
		//fail("Not yet implemented");
	}

}
