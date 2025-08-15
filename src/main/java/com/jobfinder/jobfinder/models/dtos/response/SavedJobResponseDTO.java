package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SavedJobResponseDTO {
    private Long savedJobId;
    private Long jobId;
    private String jobTitle;
    private String companyName;
    private String location;
    private Float salary;
    private Long userId;
    private LocalDateTime savedAt;
    private LocalDateTime jobPostedAt;
    private boolean isActive;
}