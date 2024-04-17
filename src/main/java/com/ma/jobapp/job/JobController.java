package com.ma.jobapp.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

	
@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
    	return new ResponseEntity<> (jobService.findAll(), HttpStatus.OK);
        //return jobService.findAll();
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<> ("Job added successfully",HttpStatus.CREATED);
    }
    
    @GetMapping("/jobs/{id}")
    // uses responce entity with Job object to control over status codes
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    	
    	Job job = jobService.getJobById(id);
    	if(job != null)
    		return new ResponseEntity<Job> (job, HttpStatus.OK);
    	return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    	//return new Job(1L, "none", "none", "none", "none", "none");
    }
}

