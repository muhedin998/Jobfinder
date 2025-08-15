package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDTOResponseMapper {
    
    @Autowired
    private SkillDTOMapper skillDTOMapper;
    
    public UserResponseDTO toDto(AppUser entity) {
        if (entity == null) return null;
        
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        dto.setCreatedAt(entity.getDateCreated());
        
        if (entity.getSkills() != null) {
            dto.setSkills(entity.getSkills().stream()
                    .map(skill -> skillDTOMapper.apply(skill, skill.getId()))
                    .collect(Collectors.toSet()));
        }
        
        return dto;
    }
}