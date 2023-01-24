package com.cg.fms.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.advices.ResourceNotFoundException;
import com.cg.fms.dao.ILandDao;
import com.cg.fms.dto.Land;

@Service
public class LandServiceImpl implements LandService{
	@Autowired
	ILandDao repo;

	public Land getLand(int surveyNumber) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Land id is not present in the database");
		return repo.findById(surveyNumber).orElseThrow(s1);
	}

	public Land addLand(Land land) {
		// TODO Auto-generated method stub
			repo.save(land);
			return land;
	}

	public Land updateLand(Land land) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Land id is not present in the database");
			Land l=repo.findById(land.getLandId()).orElseThrow(s1);
			repo.save(land);
			return land;
	}

	@Override
	public Land removeLandDetails(int landId) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Land id is not present in the database");
		Land l=repo.findById(landId).orElseThrow(s1);
			repo.delete(l);
			return l;
	}

	public List<Land> getAllLands() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
