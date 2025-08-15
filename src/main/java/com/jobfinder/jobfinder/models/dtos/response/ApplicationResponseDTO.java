package com.jobfinder.jobfinder.models.dtos.response;

import com.jobfinder.jobfinder.models.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationResponseDTO {
    private Long applicationId;
    private Long jobId;
    private String jobTitle;
    private Long applicantId;
    private String applicantName;
    private String applicantEmail;
    private LocalDateTime applicationDate;
    private Status status;
    private String coverLetter;
    private String resumeUrl;
}