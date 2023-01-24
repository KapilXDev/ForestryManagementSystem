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

import com.cg.fms.dto.Land;
import com.cg.fms.dto.Orders;
import com.cg.fms.service.OrderServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderServiceImpl orderservice;
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Land>> getAllOrders(){
		List<Orders> a=orderservice.getAllOrders();
		ResponseEntity r=new ResponseEntity<List<Orders>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addOrder")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Orders> addOrder(@RequestBody @Valid Orders order){
		Orders a=orderservice.addOrder(order);
		ResponseEntity r=new ResponseEntity<Orders>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<Orders> updateOrder(@RequestBody @Valid Orders order){
		Orders a;
		try {
			a = orderservice.updateOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = orderservice.addOrder(order);
		}
		ResponseEntity r=new ResponseEntity<Orders>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getOrder/{id}")
	public ResponseEntity<Orders> getOrder(@PathVariable int id) throws Exception{
		Orders a=orderservice.getOrder(id);
		ResponseEntity r=new ResponseEntity<Orders>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteOrder/{orderNumber}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Orders> deleteOrder(@PathVariable int orderNumber) throws Exception{
		Orders a=orderservice.deleteOrder(orderNumber);
		ResponseEntity r=new ResponseEntity<Orders>(a, HttpStatus.OK);
		return r;
		
	}
	


}
