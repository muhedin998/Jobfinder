package com.jobfinder.jobfinder.models.dtos.response;

import java.time.LocalDateTime;

public class JobViewResponseDTO {
    private Long id;
    private JobResponseDTO job;
    private UserResponseDTO user;
    private LocalDateTime viewedAt;
}
