package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.dtos.request.CreateJobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.request.UpdateJobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import com.jobfinder.jobfinder.services.Impl.JobServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/jobs")
@CrossOrigin("*")
public class JobController {
    
    @Autowired
    private JobServiceImpl jobService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<JobResponseDTO> createJob(@Valid @RequestBody CreateJobRequestDTO request) {
        JobResponseDTO response = jobService.createJob(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<JobResponseDTO> updateJob(
            @PathVariable Long id,
            @Valid @RequestBody UpdateJobRequestDTO request) {
        JobResponseDTO response = jobService.updateJob(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) JobType jobType,
            @RequestParam(required = false) ExperienceLevel experienceLevel,
            @RequestParam(required = false) Boolean isRemote) {
        List<Job> jobs = jobService.searchJobs(title, location, jobType, experienceLevel, isRemote);
        return ResponseEntity.ok(jobs);
    }
    
    @GetMapping("/my-jobs")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Job>> getMyJobs() {
        List<Job> jobs = jobService.getJobsByCurrentUser();
        return ResponseEntity.ok(jobs);
    }
}
