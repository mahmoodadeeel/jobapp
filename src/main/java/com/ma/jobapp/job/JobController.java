package com.ma.jobapp.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	
@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //@GetMapping("/jobs")
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
    	return new ResponseEntity<> (jobService.findAll(), HttpStatus.OK);
        //return jobService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<> ("Job added successfully",HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    // uses responce entity with Job object to control over status codes
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    	Job job = jobService.getJobById(id);
    	if(job != null)
    		return new ResponseEntity<Job> (job, HttpStatus.OK);
    	return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
    	boolean deleted = jobService.deleteJobById(id);
    	if(deleted)
    		return new ResponseEntity<> ("Job deleted successfully", 
    				HttpStatus.OK);
    	return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    //@RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT )
    public ResponseEntity<String> updateJob(@PathVariable long id,
    		@RequestBody Job updatedJob){
    	boolean updated = jobService.updateJob(id,updatedJob);
    	if (updated)
    		return new ResponseEntity<>("Job updated successfully.", HttpStatus.OK);
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

