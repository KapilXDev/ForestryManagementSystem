package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Orders;


public interface OrderService {

	public Orders getOrder(int orderNumber) throws Exception;

	public Orders addOrder(Orders order);

	public Orders updateOrder(Orders order) throws Exception;

	public Orders deleteOrder(int orderNumber) throws Exception;
	
	public List<Orders> getAllOrders();
}
