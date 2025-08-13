package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;
    
    private String fileName;
    
    private String fileUrl;
    
    private String fileType;
    
    private Long fileSize;
    
    private Boolean isDefault;
    
    private Boolean isPublic;
    
    @Column(length = 1000)
    private String description;
    
    private LocalDateTime uploadedAt;
    
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        uploadedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        isDefault = false;
        isPublic = false;
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}