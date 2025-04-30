package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import lombok.Data;

@Data
public class JobApplicationRequestDTO {
    private String coverLetter;
    private String resumeLink;
    private JobResponseDTO job;
    private UserResponseDTO user;
    private String cvLink;

}
