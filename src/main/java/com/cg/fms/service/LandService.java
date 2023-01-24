package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Land;

public interface LandService {
	public Land getLand(int surveyNumber) throws Exception;

	public Land addLand(Land land);

	public Land updateLand(Land land) throws Exception;

	public Land removeLandDetails(int landId) throws Exception;
	
	public List<Land> getAllLands();
}
