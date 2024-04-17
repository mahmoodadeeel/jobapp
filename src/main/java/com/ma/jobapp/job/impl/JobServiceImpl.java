package com.ma.jobapp.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ma.jobapp.job.Job;
import com.ma.jobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService {
	private List<Job> jobs = new ArrayList<>();
	private Long nextId = 1L;
	
	@Override
	public List<Job> findAll() {
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobs.add(job);
	}

}
