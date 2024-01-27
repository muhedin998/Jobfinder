package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.Job;
import com.jobfinder.jobfinder.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
@CrossOrigin("*")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/create")
    public ResponseEntity<Job> createJob (@RequestBody Job job) {
        var newJob = job;
        newJob.setDatePosted(LocalDate.now());
        return ResponseEntity.ok(jobService.createJob(newJob));
    }

    @GetMapping("/get-all-jobs")
    public ResponseEntity<List<Job>> getAllJobs () {
        System.out.println(LocalDate.now());
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PostMapping("/job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted !");
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Job>> getJobByTitle(@PathVariable String title){
        //TODO: Implement title serch !
        List<Job> jobs = jobService.getAllJobs().stream().filter(job -> job.getTitel().contains(title)).collect(Collectors.toList());
        return ResponseEntity.ok(jobs);
    }
}
