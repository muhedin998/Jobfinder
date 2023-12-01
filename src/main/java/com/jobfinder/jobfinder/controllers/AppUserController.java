package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.AppUser;
import com.jobfinder.jobfinder.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/creata")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.createUser(appUser));
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.ok("User deleted !");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AppUser> createUser(@PathVariable Long id) {
        return ResponseEntity.ok(appUserService.getUserById(id));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<AppUser>> createUser() {
        return ResponseEntity.ok(appUserService.getAllUser());
    }
}
