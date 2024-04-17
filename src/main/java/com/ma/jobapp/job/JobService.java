package com.ma.jobapp.job;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface JobService {
	List<Job> findAll();
	void createJob(Job job);
	boolean updateJob(Long id, Job updatedJob);
	Job getJobById(Long id);
	boolean deleteJobById(Long id);
}
