package com.jobfinder.jobfinder.models.dtos.response;

import com.jobfinder.jobfinder.models.entities.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private AppUser user;
    private String token;
}
