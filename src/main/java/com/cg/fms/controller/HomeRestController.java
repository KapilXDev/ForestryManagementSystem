/*package com.cg.fms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Land;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.service.ContractServiceImpl;
import com.cg.fms.service.CustomerServiceImpl;
import com.cg.fms.service.IAdminServiceImpl;
import com.cg.fms.service.LandServiceImpl;
import com.cg.fms.service.OrderServiceImpl;
import com.cg.fms.service.ProductServiceImpl;
import com.cg.fms.service.SchedulerServiceImpl;

@RestController
@RequestMapping("/api")
public class HomeRestController {
	
	@Autowired
	IAdminServiceImpl adminservice;
	@Autowired
	CustomerServiceImpl customerservice;
	@Autowired
	ContractServiceImpl contractservice;
	@Autowired
	LandServiceImpl landservice;
	@Autowired
	OrderServiceImpl orderservice;
	@Autowired
	ProductServiceImpl productservice;
	@Autowired
	SchedulerServiceImpl schedulerservice;
	
	@GetMapping("/getAdmin/{name}")
	public ResponseEntity<Admin> getAdmin(@PathVariable int id) throws Exception{
		Admin a=adminservice.getAdmin(id);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
	}
	
	@GetMapping("/getAdmin1")
	public ResponseEntity<Admin> getAdmin1(@PathVariable String name){
		Admin a=adminservice.getAdminByName(name);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
	}
	
	
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> a=adminservice.getAllAdmins();
		ResponseEntity r=new ResponseEntity<List<Admin>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteAdmin(int id) throws Exception{
		String a=adminservice.deleteAdmin(id);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<String> updateAdmin(Admin admin){
		String a;
		try {
			a = adminservice.updateAdmin(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = adminservice.addAdmin(admin);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(Admin admin){
		String a=adminservice.addAdmin(admin);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> a=customerservice.serviceGetAllCustomers();
		ResponseEntity r=new ResponseEntity<List<Customer>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(Customer customer){
		String a=customerservice.serviceAddCustomer(customer);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(Customer customer){
		String a;
		try {
			a = customerservice.serviceUpdateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = customerservice.serviceAddCustomer(customer);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) throws Exception{
		Customer a=customerservice.serviceGetCustomer(id);
		ResponseEntity r=new ResponseEntity<Customer>(a, HttpStatus.OK);
		return r;
	}
	/*
	@GetMapping("/getAdmin1")
	public ResponseEntity<Admin> getAdmin1(@PathVariable String name){
		Admin a=adminservice.getAdminByName(name);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
	}*/
	
	/*@DeleteMapping("/deleteCustomer")
	public ResponseEntity<String> deleteCustomer(int id) throws Exception{
		String a=customerservice.serviceDeleteCustomer(id);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@GetMapping("/getAllLand")
	public ResponseEntity<List<Land>> getAllLand(){
		List<Land> a=landservice.getAllLands();
		ResponseEntity r=new ResponseEntity<List<Land>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addLand")
	public ResponseEntity<String> addLand(Land land){
		String a=landservice.addLand(land);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateLand")
	public ResponseEntity<String> updateLand(Land land){
		String a;
		try {
			a = landservice.updateLand(land);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = landservice.addLand(land);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getLand/{id}")
	public ResponseEntity<Land> getLand(@PathVariable int id) throws Exception{
		Land a=landservice.getLand(id);
		ResponseEntity r=new ResponseEntity<Land>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteLand")
	public ResponseEntity<String> deleteLand(int landId) throws Exception{
		String a=landservice.removeLandDetails(landId);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@GetMapping("/getAllContract")
	public ResponseEntity<List<Contract>> getAllContract(){
		List<Contract> a=contractservice.getAllContracts();
		ResponseEntity r=new ResponseEntity<List<Contract>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addContract")
	public ResponseEntity<String> addContract(Contract contract){
		String a=contractservice.addContract(contract);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateContract")
	public ResponseEntity<String> updateContract(Contract contract){
		String a;
		try {
			a = contractservice.updateContract(contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = contractservice.addContract(contract);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getContract/{id}")
	public ResponseEntity<Contract> getContract(@PathVariable int id) throws Exception{
		Contract a=contractservice.getContract(id);
		ResponseEntity r=new ResponseEntity<Contract>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteContract")
	public ResponseEntity<String> deleteContract(int contractNumber) throws Exception{
		String a=contractservice.deleteContract(contractNumber);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Land>> getAllProducts(){
		List<Product> a=productservice.getAllProducts();
		ResponseEntity r=new ResponseEntity<List<Product>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addOrder(Product product){
		String a=productservice.addProduct(product);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateOrder(Product product){
		String a;
		try {
			a = productservice.updateProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = productservice.addProduct(product);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) throws Exception{
		Product a=productservice.getProduct(id);
		ResponseEntity r=new ResponseEntity<Product>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<String> deleteProduct(int ProductId) throws Exception{
		String a=productservice.deleteProduct(ProductId);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	


	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Land>> getAllOrders(){
		List<Orders> a=orderservice.getAllOrders();
		ResponseEntity r=new ResponseEntity<List<Orders>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addOrder(Orders order){
		String a=orderservice.addOrder(order);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<String> updateOrder(Orders order){
		String a;
		try {
			a = orderservice.updateOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = orderservice.addOrder(order);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getOrder/{id}")
	public ResponseEntity<Orders> getOrder(@PathVariable int id) throws Exception{
		Orders a=orderservice.getOrder(id);
		ResponseEntity r=new ResponseEntity<Orders>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteOrder")
	public ResponseEntity<String> deleteOrder(int orderNumber) throws Exception{
		String a=orderservice.deleteOrder(orderNumber);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	


	@GetMapping("/getAllSchedulers")
	public ResponseEntity<List<Land>> getAllSchedulers(){
		List<Scheduler> a=schedulerservice.getAllSchedulers();
		ResponseEntity r=new ResponseEntity<List<Scheduler>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addSchduler")
	public ResponseEntity<String> addScheduler(Scheduler scheduler){
		String a=schedulerservice.addScheduler(scheduler);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateScheduler")
	public ResponseEntity<String> updateScheduler(Scheduler scheduler){
		String a;
		try {
			a = schedulerservice.updateScheduler(scheduler);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = schedulerservice.addScheduler(scheduler);
		}
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getSchedulert/{id}")
	public ResponseEntity<Product> getScheduler(@PathVariable int id) throws Exception{
		Scheduler a=schedulerservice.getScheduler(id);
		ResponseEntity r=new ResponseEntity<Scheduler>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteScheduler")
	public ResponseEntity<String> deleteScheduler(int SchedulerId) throws Exception{
		String a=schedulerservice.deleteScheduler(SchedulerId);
		ResponseEntity r=new ResponseEntity<String>(a, HttpStatus.OK);
		return r;
		
	}
	
}
*/