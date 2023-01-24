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
import com.cg.fms.service.LandServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LandController {
	@Autowired
	LandServiceImpl landservice;
	@GetMapping("/getAllLand")
	public ResponseEntity<List<Land>> getAllLand(){
		List<Land> a=landservice.getAllLands();
		ResponseEntity r=new ResponseEntity<List<Land>>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PostMapping("/addLand")
	public ResponseEntity<Land> addLand(@RequestBody @Valid Land land){
		Land a=landservice.addLand(land);
		ResponseEntity r=new ResponseEntity<Land>(a, HttpStatus.OK);
		return r;
		
	}
	
	@PutMapping("/updateLand")
	public ResponseEntity<Land> updateLand(@RequestBody @Valid Land land){
		Land a;
		try {
			a = landservice.updateLand(land);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			a = landservice.addLand(land);
		}
		ResponseEntity r=new ResponseEntity<Land>(a, HttpStatus.OK);
		return r;
		
	}
	
	
	@GetMapping("/getLand/{id}")
	public ResponseEntity<Land> getLand(@PathVariable int id) throws Exception{
		Land a=landservice.getLand(id);
		ResponseEntity r=new ResponseEntity<Land>(a, HttpStatus.OK);
		return r;
	}
	
	@DeleteMapping("/deleteLand/{id}")
	public ResponseEntity<Land> deleteLand(@PathVariable int landId) throws Exception{
		Land a=landservice.removeLandDetails(landId);
		ResponseEntity r=new ResponseEntity<Land>(a, HttpStatus.OK);
		return r;
		
	}

}
