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

import com.cg.fms.dto.Admin;
import com.cg.fms.service.IAdminServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/test/admin")
public class AdminController {
	
	@Autowired
	IAdminServiceImpl adminservice;
	@GetMapping("/getAdmin/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Admin> getAdmin(@PathVariable int id) throws Exception{
		Admin a=adminservice.getAdmin(id);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
	}
	
	@GetMapping("/getAdminByName/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Admin> getAdmin1(@PathVariable String name) throws Exception{
		Admin a=adminservice.getAdminByName(name);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
	}
	
	
	@GetMapping("/getAllAdmin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> a=adminservice.getAllAdmins();
		ResponseEntity r=new ResponseEntity<List<Admin>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable int id) throws Exception{
		Admin a=adminservice.deleteAdmin(id);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateAdmin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Admin> updateAdmin(@RequestBody @Valid Admin admin){
		Admin a;
		try {
			a = adminservice.updateAdmin(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = adminservice.addAdmin(admin);
		}
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addAdmin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Admin> addAdmin(@RequestBody @Valid Admin admin){
		Admin a=adminservice.addAdmin(admin);
		ResponseEntity r=new ResponseEntity<Admin>(a, HttpStatus.OK);
		return r;
		
	}
	
	

}
