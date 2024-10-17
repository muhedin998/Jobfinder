package com.jobfinder.jobfinder.models.dtos.request;

import lombok.Data;

import java.util.Set;

@Data
public class UserCreateRequestDTO {
    private String username;
    private String email;
    private String password;
    private String role;
    private String fullName;
    private Set<Long> skillIds;
}
