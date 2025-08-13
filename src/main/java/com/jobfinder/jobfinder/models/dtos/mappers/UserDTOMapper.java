package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.entities.AppUser;

import java.util.stream.Collectors;

public enum UserDTOMapper implements EntityMapper<UserResponseDTO, AppUser, Long> {
    INSTANCE;

    @Override
    public UserResponseDTO apply(AppUser entity, Long id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(entity.getId());
        userResponseDTO.setUsername(entity.getUsername());
        userResponseDTO.setEmail(entity.getEmail());
        userResponseDTO.setRole(entity.getRole());
        userResponseDTO.setSkills(entity.getSkills().stream().map(skill ->
                SkillDTOMapper.INSTANCE.apply(skill, skill.getId()))
                .collect(Collectors.toSet()));
        userResponseDTO.setCreatedAt(entity.getDateCreated());
        return userResponseDTO;
    }

}
