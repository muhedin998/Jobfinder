package com.jobfinder.jobfinder.models.dtos.response;

import java.time.LocalDateTime;

public class SavedJobResponseDTO {
    private Long id;
    private JobResponseDTO job;
    private LocalDateTime savedAt;
}
