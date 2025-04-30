package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.entities.AppUser;
import com.jobfinder.jobfinder.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public enum UserMapper implements DTOMapper<AppUser, UserResponseDTO> {
    INSTANCE;

    @Autowired
    private AppUserService userService;


    @Override
    public AppUser apply(UserResponseDTO dto) {
        AppUser user = userService.getUserById(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setSkills(dto.getSkills().stream().map(SkillMapper.INSTANCE::apply).collect(Collectors.toSet()));
        user.setRole(dto.getRole());
        user.setDateCreated(dto.getCreatedAt());

        return user;
    }
}
