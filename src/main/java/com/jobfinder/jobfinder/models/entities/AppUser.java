package com.jobfinder.jobfinder.models.entities;

import com.jobfinder.jobfinder.models.dtos.request.UserCreateRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String username;

    private String email;

    private String password;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "user")
    private List<Applications> applications;

    @OneToMany(mappedBy = "user")
    private List<Job> jobs;

    @OneToMany(mappedBy = "user")
    private Set<Notifications> notifications;

    @ManyToMany
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;

    private LocalDateTime dateCreated;


    public static AppUser getEmptyUser() {
        return AppUser.builder()
                .fullName("")
                .username("")
                .email("")
                .password("")
                .role(Roles.USER)
                .build();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }

    public void removeJob(Job job) {
        this.jobs.remove(job);
    }

    public void addApplication(Applications application) {
        this.applications.add(application);
    }

    public void removeApplication(Applications application) {
        this.applications.remove(application);
    }

    public void addNotification(Notifications notification) {
        this.notifications.add(notification);
    }

    public void removeNotification(Notifications notification) {
        this.notifications.remove(notification);
    }

    public AppUser toEntity(UserCreateRequestDTO userDTO) {
        AppUser user = new AppUser();
        user.setFullName(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setDateCreated(LocalDateTime.now());
        return user;
    }
}
