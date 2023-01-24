package com.cg.fms.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.advices.ResourceNotFoundException;
import com.cg.fms.dao.IOrderDao;
import com.cg.fms.dto.Orders;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	IOrderDao repo;

	@Override
	public Orders getOrder(int orderNumber) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Order id is not present in the database");
		return repo.findById(orderNumber).orElseThrow(s1);
	}

	@Override
	public Orders addOrder(Orders order) {
		// TODO Auto-generated method stub
			repo.save(order);
			return order;
	}

	@Override
	public Orders updateOrder(Orders order) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Order id is not present in the database");
			Orders o=repo.findById(order.getOrderNumber()).orElseThrow(s1);
			repo.save(order);
			return order;
	}

	@Override
	public Orders deleteOrder(int orderNumber) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Order id is not present in the database");
		Orders o=repo.findById(orderNumber).orElseThrow(s1);
		//if(o != null) {
			repo.delete(o);
		//}
		return o;
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
