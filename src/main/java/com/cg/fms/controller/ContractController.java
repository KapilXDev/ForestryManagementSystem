package com.cg.fms.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Contract;
import com.cg.fms.service.ContractServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContractController {
	@Autowired
	ContractServiceImpl contractservice;
	@PostMapping("/addContract")
	public ResponseEntity<Contract> addContract(@RequestBody Contract contract){
		Contract a=contractservice.addContract(contract);
		ResponseEntity r=new ResponseEntity<Contract>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateContract")
	public ResponseEntity<Contract> updateContract(@RequestBody @Valid Contract contract){
		Contract a;
		try {
			a = contractservice.updateContract(contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = contractservice.addContract(contract);
		}
		ResponseEntity r=new ResponseEntity<Contract>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getContract/{id}")
	public ResponseEntity<Contract> getContract(@PathVariable int id) throws Exception{
		Contract a=contractservice.getContract(id);
		ResponseEntity r=new ResponseEntity<Contract>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteContract/{id}")
	public ResponseEntity<Contract> deleteContract(@PathVariable int contractNumber) throws Exception{
		Contract a=contractservice.deleteContract(contractNumber);
		ResponseEntity r=new ResponseEntity<Contract>(a, HttpStatus.OK);
		return r;
		
	}

	


}
