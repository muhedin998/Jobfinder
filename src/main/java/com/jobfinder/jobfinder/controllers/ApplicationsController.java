package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.services.ApplicationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationsController {
    private final ApplicationsService applicationsService;

    @GetMapping("/user/{id}")
    public List<JobApplicationResponseDTO> getByUser(@PathVariable Long id) {
        return applicationsService.getApplicationsByUser(id);
    }

    @GetMapping("/job/{id}")
    public List<JobApplicationResponseDTO> getByJob(@PathVariable Long id) {
        return applicationsService.getApplicationsByJob(id);
    }

    @PostMapping("/apply")
    public ResponseEntity<Void> applyForJob(@RequestBody JobApplicationRequestDTO jobApplicationRequestDTO) {
        try {
            applicationsService.applyForJob(jobApplicationRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateApplication(@PathVariable Long id, @RequestBody JobApplicationRequestDTO jobApplicationRequestDTO) {
        try {
            applicationsService.updateApplication(id, jobApplicationRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        try {
            applicationsService.deleteApplication(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
