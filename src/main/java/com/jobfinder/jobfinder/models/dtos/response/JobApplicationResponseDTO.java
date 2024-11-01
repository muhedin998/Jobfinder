package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobApplicationResponseDTO {
    private Long applicationId;
    private JobResponseDTO job;
    private UserResponseDTO user;
    private String applicationStatus;
    private LocalDateTime appliedAt;
    private String coverLetter;
    private String cvLink;
}
