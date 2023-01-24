package com.cg.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.fms.dto.Product;


public interface IProductDao extends JpaRepository<Product, Integer>{
	/*
	public Product findProduct(int productId);

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	@Query("Delete from Product a where a.productId=productId")
	public boolean deleteProduct(int productId);
	
	public List<Product> findAllProducts();*/
}