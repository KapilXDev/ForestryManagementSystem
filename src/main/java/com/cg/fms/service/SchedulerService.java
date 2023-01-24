package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Scheduler;

public interface SchedulerService {
	public Scheduler getScheduler(int schedulerId) throws Exception;

	public Scheduler addScheduler(Scheduler scheduler);

	public Scheduler updateScheduler(Scheduler scheduler) throws Exception;

	public Scheduler deleteScheduler(int schedulerId) throws Exception;

	public List<Scheduler> getAllSchedulers();
}
