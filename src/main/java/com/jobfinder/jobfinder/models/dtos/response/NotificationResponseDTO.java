package com.jobfinder.jobfinder.models.dtos.response;

import java.time.LocalDateTime;

public class NotificationResponseDTO {
    private Long notificationId;
    private String message;
    private boolean isRead;
    private LocalDateTime createdAt;
}
