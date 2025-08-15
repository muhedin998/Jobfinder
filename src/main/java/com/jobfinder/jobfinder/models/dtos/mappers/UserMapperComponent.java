package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.entities.AppUser;
import com.jobfinder.jobfinder.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapperComponent {

    @Autowired
    private AppUserService userService;
    
    @Autowired
    private SkillMapperComponent skillMapper;

    public AppUser toEntity(UserResponseDTO dto) {
        if (dto == null) return null;
        
        AppUser user;
        if (dto.getUserId() != null) {
            user = userService.getUserById(dto.getUserId());
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setRole(dto.getRole());
            user.setDateCreated(dto.getCreatedAt());
        } else {
            user = new AppUser();
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setRole(dto.getRole());
            user.setDateCreated(dto.getCreatedAt());
        }

        if (dto.getSkills() != null) {
            user.setSkills(dto.getSkills().stream()
                    .map(skillMapper::toEntity)
                    .collect(Collectors.toSet()));
        }

        return user;
    }

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
                    .map(skillMapper::toDto)
                    .collect(Collectors.toSet()));
        }
        
        return dto;
    }
}