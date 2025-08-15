package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

@Data
public class SkillResponseDTO {
    private Long skillId;
    private String skillName;
    private String description;
    private String category;
}