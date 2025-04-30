package com.jobfinder.jobfinder.models.dtos;

import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;

import java.time.LocalDateTime;

public class SavedJobDTO {
    private Long id;
    private JobResponseDTO job;
    private LocalDateTime savedAt;
}
