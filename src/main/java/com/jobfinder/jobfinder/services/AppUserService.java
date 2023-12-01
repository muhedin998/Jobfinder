package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createUser(AppUser appUser);

    void deleteUser(Long id);

    List<AppUser> getAllUser();

    AppUser getUserById(Long id);
}
