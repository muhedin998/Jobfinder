package com.jobfinder.jobfinder.models.dtos.request;

public class MessageRequestDTO {
    private Long receiverId;
    private Long jobId;  // Optional, depending on whether it's related to a job
    private String message;
}
