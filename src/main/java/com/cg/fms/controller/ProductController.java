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
import com.cg.fms.dto.Product;
import com.cg.fms.service.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductServiceImpl productservice;
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Land>> getAllProducts(){
		List<Product> a=productservice.getAllProducts();
		ResponseEntity r=new ResponseEntity<List<Product>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addProduct")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> addOrder(@RequestBody @Valid Product product){
		Product a=productservice.addProduct(product);
		ResponseEntity r=new ResponseEntity<Product>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateOrder(@RequestBody @Valid Product product){
		Product a;
		try {
			a = productservice.updateProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = productservice.addProduct(product);
		}
		ResponseEntity r=new ResponseEntity<Product>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) throws Exception{
		Product a=productservice.getProduct(id);
		ResponseEntity r=new ResponseEntity<Product>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteProduct/{ProductId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> deleteProduct(@PathVariable int ProductId) throws Exception{
		Product a=productservice.deleteProduct(ProductId);
		ResponseEntity r=new ResponseEntity<Product>(a, HttpStatus.OK);
		return r;
		
	}
	


}
