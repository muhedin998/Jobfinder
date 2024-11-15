package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.enums.Roles;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Set;

@Data
public class UserCreateRequestDTO {
    private String username;
    private String email;
    private String password;
    private Roles role;
    private String fullName;
    private Set<Long> skillIds;
}
