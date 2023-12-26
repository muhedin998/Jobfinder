package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    AppUser createUser(AppUser appUser);

    void deleteUser(Long id);

    List<AppUser> getAllUser();

    AppUser getUserById(Long id);

    AppUser findByUsername(String username);

    Optional<AppUser> findOptionalUser(String username);
}
