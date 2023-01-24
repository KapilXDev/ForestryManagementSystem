package com.cg.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.fms.dto.Orders;

public interface IOrderDao extends JpaRepository<Orders, Integer>{

	/*
	public Orders findOrder(int orderNumber);

	public boolean addOrder(Orders order);

	public boolean updateOrder(Orders order);

	@Query("Delete from Orders a where a.orderNumber=orderNumber")
	public boolean deleteOrder(int orderNumber);
	
	public List<Orders> findAllOrders();*/
}
