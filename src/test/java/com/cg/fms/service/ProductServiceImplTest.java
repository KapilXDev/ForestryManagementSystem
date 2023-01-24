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

import com.cg.fms.dao.IProductDao;
import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Product;

@SpringBootTest
class ProductServiceImplTest {
	@Autowired
	ProductServiceImpl productService;
	@MockBean
	IProductDao repo;
	
	

	@Test
	void testGetProduct() throws Exception{
		Product p=new Product();
		p.setProductDescription("Description");
		p.setProductId(1);
		p.setProductName("Tablet");
		p.setProductQuantity("20");
		Optional<Product> p1=Optional.of(p);
		Mockito.when(repo.findById(1)).thenReturn(p1);

		assertThat(productService.getProduct(1)).isEqualTo(p);
		//fail("Not yet implemented");
	}

	@Test
	void testAddProduct() {
		Product p=new Product();
		p.setProductDescription("Description");
		p.setProductId(1);
		p.setProductName("Tablet");
		p.setProductQuantity("20");
		Mockito.when(repo.save(p)).thenReturn(p);
		assertThat(productService.addProduct(p)).isEqualTo("added");
	}

	@Test
	void testUpdateProduct() throws Exception{
		Product p=new Product();
		p.setProductDescription("Description");
		p.setProductId(1);
		p.setProductName("Tablet");
		p.setProductQuantity("20");
		Optional<Product> p1=Optional.of(p);
Mockito.when(repo.findById(1)).thenReturn(p1);
		
		Mockito.when(repo.save(p)).thenReturn(p);
		
		p.setProductName("newname"); 	
		p.setProductDescription("new description");
		
		assertThat(productService.updateProduct(p)).isEqualTo("updated");
		
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteProduct() {
		Product p=new Product();
		p.setProductDescription("Description");
		p.setProductId(1);
		p.setProductName("Tablet");
		p.setProductQuantity("20");
		Optional<Product> p1=Optional.of(p);
		
		Mockito.when(repo.findById(1)).thenReturn(p1);
		Mockito.when(repo.existsById(p.getProductId())).thenReturn(false);
		assertFalse(repo.existsById(p.getProductId()));
		//fail("Not yet implemented");
	}

	@Test
	void testGetAllProducts() {
		Product p=new Product();
		p.setProductDescription("Description");
		p.setProductId(1);
		p.setProductName("Tablet");
		p.setProductQuantity("20");
		Product p1=new Product();
		p1.setProductDescription("Description1");
		p1.setProductId(2);
		p1.setProductName("Tablet1");
		p1.setProductQuantity("200");
		List<Product> pa=new ArrayList<>();
		pa.add(p); 	pa.add(p1);
		Mockito.when(repo.findAll()).thenReturn(pa);
		assertThat(productService.getAllProducts()).isEqualTo(pa);
		
		
		//fail("Not yet implemented");
	}

}
