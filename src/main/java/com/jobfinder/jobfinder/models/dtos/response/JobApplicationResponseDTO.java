package com.jobfinder.jobfinder.models.dtos.response;

import ch.qos.logback.core.status.Status;
import com.jobfinder.jobfinder.models.enums.JobStatus;
import jdk.jshell.Snippet;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobApplicationResponseDTO {
    private Long applicationId;
    private JobResponseDTO job;
    private UserResponseDTO user;
    private String applicationStatus;
    private LocalDateTime appliedAt;
    private String cvLink;
    private String coverLetter;
}
