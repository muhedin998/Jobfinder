package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {
    private Long notificationId;
    private String message;
    private boolean isRead;
    private LocalDateTime createdAt;
}
