package com.cg.fms.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.advices.ResourceNotFoundException;
import com.cg.fms.dao.IProductDao;
import com.cg.fms.dto.Product;

@Service
public class ProductServiceImpl implements  ProductService{
	
	@Autowired
	IProductDao repo;

	@Override
	public Product getProduct(int productId) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Product id is not present in the database");
		return repo.findById(productId).orElseThrow(s1);
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
			repo.save(product);
			return product;
	}

	@Override
	public Product updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Product id is not present in the database");
			Product p=repo.findById(product.getProductId()).orElseThrow(s1);
			repo.save(product);
			return product;
	}

	@Override
	public Product deleteProduct(int productId) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Product id is not present in the database");
		Product p=repo.findById(productId).orElseThrow(s1);
		//if(p != null) {
			repo.delete(p);
		//}
			return p;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
