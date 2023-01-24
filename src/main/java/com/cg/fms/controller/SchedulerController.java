package com.cg.fms.controller;

import java.util.List;

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

import com.cg.fms.dto.Land;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.service.SchedulerServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SchedulerController {
	@Autowired
	SchedulerServiceImpl schedulerservice;

	@GetMapping("/getAllSchedulers")
	public ResponseEntity<List<Land>> getAllSchedulers(){
		List<Scheduler> a=schedulerservice.getAllSchedulers();
		ResponseEntity r=new ResponseEntity<List<Scheduler>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addScheduler")
	public ResponseEntity<Scheduler> addScheduler(@RequestBody @Valid Scheduler scheduler){
		Scheduler a=schedulerservice.addScheduler(scheduler);
		ResponseEntity r=new ResponseEntity<Scheduler>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateScheduler")
	public ResponseEntity<Scheduler> updateScheduler(@RequestBody @Valid Scheduler scheduler){
		Scheduler a;
		try {
			a = schedulerservice.updateScheduler(scheduler);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = schedulerservice.addScheduler(scheduler);
		}
		ResponseEntity r=new ResponseEntity<Scheduler>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getSchedulert/{id}")
	public ResponseEntity<Product> getScheduler(@PathVariable int id) throws Exception{
		Scheduler a=schedulerservice.getScheduler(id);
		ResponseEntity r=new ResponseEntity<Scheduler>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteScheduler/{id}")
	public ResponseEntity<Scheduler> deleteScheduler(@PathVariable int SchedulerId) throws Exception{
		Scheduler a=schedulerservice.deleteScheduler(SchedulerId);
		ResponseEntity r=new ResponseEntity<Scheduler>(a, HttpStatus.OK);
		return r;
		
	}
	


}
