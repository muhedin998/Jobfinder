package com.jobfinder.jobfinder.models.dtos.response;

import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.enums.Roles;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserResponseDTO {
    private Long userId;
    private String username;
    private String email;
    private Roles role;
    private Set<SkillDTO> skills;
    private LocalDateTime createdAt;
}
