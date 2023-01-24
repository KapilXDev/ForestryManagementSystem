package com.cg.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Land;

@Repository
public interface ILandDao extends JpaRepository<Land, Integer>{
	
	/*
	public Land findLand(int surveyNumber);

	public boolean addLand(Land land);

	public boolean updateLand(Land land);
	
	@Query("Delete from Land a where a.contractnumber=contractNumber")
	public boolean deleteLand(int surveyNumber);
	
	public List<Land> findAllLands();*/
}
