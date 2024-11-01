package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.services.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicatinosControllers {

    @Autowired
    private final ApplicationsService applicationsService;

    public ApplicatinosControllers(ApplicationsService applicationsService) {
        this.applicationsService = applicationsService;
    }

    @GetMapping("/user/{id]")
    public List<JobApplicationResponseDTO> getByUser(@PathVariable Long id) {
        return applicationsService.getApplicationsByUser(id);
    }
}
