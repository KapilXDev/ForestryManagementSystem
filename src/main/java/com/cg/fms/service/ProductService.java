package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Product;

public interface ProductService {
	public Product getProduct(int productId) throws Exception;

	public Product addProduct(Product product);

	public Product updateProduct(Product product) throws Exception;

	public Product deleteProduct(int productId) throws Exception;
	
	public List<Product> getAllProducts();
}
