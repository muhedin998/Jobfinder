package com.jobfinder.jobfinder.models.dtos.response;

import java.time.LocalDateTime;

public class MessageResponseDTO {
    private Long messageId;
    private UserResponseDTO sender;
    private UserResponseDTO receiver;
    private JobResponseDTO job;  // Include job if it's related to a job post
    private String message;
    private LocalDateTime sentAt;
}
