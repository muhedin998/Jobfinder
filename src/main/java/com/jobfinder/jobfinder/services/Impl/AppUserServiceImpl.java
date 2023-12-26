package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.AppUser;
import com.jobfinder.jobfinder.repositories.AppUserRepository;
import com.jobfinder.jobfinder.services.AppUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public AppUser createUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public void deleteUser(Long id) {
        AppUser forDelete = appUserRepository.findById(id).get();
        appUserRepository.delete(forDelete);
    }

    @Override
    public List<AppUser> getAllUser() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public AppUser findByUsername(String username) {
        Optional<AppUser> maybeUser = appUserRepository.findByUsername(username);
        if(maybeUser.isEmpty()) {
            return AppUser.getEmptyUser();
        } else {
            return maybeUser.get();
        }
    }

    @Override
    public Optional<AppUser> findOptionalUser(String username) {
        return appUserRepository.findByUsername(username);
    }
}
