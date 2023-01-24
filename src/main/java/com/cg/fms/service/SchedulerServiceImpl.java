package com.cg.fms.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.advices.ResourceNotFoundException;
import com.cg.fms.dao.ISchedulerDao;
import com.cg.fms.dto.Scheduler;

@Service
public class SchedulerServiceImpl implements SchedulerService{
	
	@Autowired
	ISchedulerDao repo;

	@Override
	public Scheduler getScheduler(int schedulerId) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Scheduler id is not present in the database");
		return repo.findById(schedulerId).orElseThrow(s1);
	}

	@Override
	public Scheduler addScheduler(Scheduler scheduler) {
		// TODO Auto-generated method stub
			repo.save(scheduler);
			return scheduler;
	}

	@Override
	public Scheduler updateScheduler(Scheduler scheduler) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Scheduler id is not present in the database");
			Scheduler s=repo.findById(scheduler.getSchedulerId()).orElseThrow(s1);
			repo.save(scheduler);
			return scheduler;
	}

	@Override
	public Scheduler deleteScheduler(int schedulerId) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Scheduler id is not present in the database");
		Scheduler s=repo.findById(schedulerId).orElseThrow(s1);
			repo.delete(s);
			return s;
	}

	@Override
	public List<Scheduler> getAllSchedulers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
