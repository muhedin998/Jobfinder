package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDTOMapper {

    @Autowired
    private SkillDTOMapper skillDTOMapper;

    public UserResponseDTO apply(AppUser entity, Long id) {
        if (entity == null) return null;
        
        return UserResponseDTO.builder()
                .userId(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(entity.getRole())
                .skills(entity.getSkills() != null ? 
                    entity.getSkills().stream()
                        .map(skill -> skillDTOMapper.apply(skill, skill.getId()))
                        .collect(Collectors.toSet()) : null)
                .createdAt(entity.getDateCreated())
                .build();
    }
}
