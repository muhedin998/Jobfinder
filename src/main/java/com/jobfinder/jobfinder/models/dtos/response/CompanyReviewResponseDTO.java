package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompanyReviewResponseDTO {
    
    private Long id;
    
    private Long companyId;
    
    private String companyName;
    
    private Long reviewerId;
    
    private String reviewerName;
    
    private Integer overallRating;
    
    private Integer workLifeBalanceRating;
    
    private Integer salaryRating;
    
    private Integer cultureRating;
    
    private Integer managementRating;
    
    private String jobTitle;
    
    private String employmentStatus;
    
    private String pros;
    
    private String cons;
    
    private String advice;
    
    private Boolean recommendToFriend;
    
    private Boolean approveOfCeo;
    
    private Boolean isAnonymous;
    
    private Boolean isVerified;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}