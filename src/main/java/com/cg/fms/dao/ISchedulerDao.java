package com.cg.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.fms.dto.Scheduler;

public interface ISchedulerDao extends JpaRepository<Scheduler, Integer>{
	/*
	public Scheduler findScheduler(int schedulerId);

	public boolean addScheduler(Scheduler scheduler);

	public boolean updateScheduler(Scheduler scheduler);

	@Query("Delete from Scheduler a where a.schedulerId=schedulerId")
	public boolean deleteScheduler(int schedulerId);
	
	public List<Scheduler> findAllSchedulers();*/
}
