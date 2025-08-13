package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.dtos.request.EducationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.EducationResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/education")
@CrossOrigin(origins = "*")
public class EducationController {

    // TODO: Inject EducationService here
    // @Autowired
    // private EducationService educationService;

    /**
     * Add new education entry
     * POST /api/v1/education
     */
    @PostMapping
    public ResponseEntity<EducationResponseDTO> createEducation(@Valid @RequestBody EducationRequestDTO request) {
        // TODO: Implement education creation logic
        // EducationResponseDTO response = educationService.createEducation(request);
        // return new ResponseEntity<>(response, HttpStatus.CREATED);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get education by ID
     * GET /api/v1/education/{educationId}
     */
    @GetMapping("/{educationId}")
    public ResponseEntity<EducationResponseDTO> getEducationById(@PathVariable Long educationId) {
        // TODO: Implement get education by ID logic
        // EducationResponseDTO response = educationService.getEducationById(educationId);
        // return ResponseEntity.ok(response);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get all education entries for a user profile
     * GET /api/v1/education/profile/{userProfileId}
     */
    @GetMapping("/profile/{userProfileId}")
    public ResponseEntity<List<EducationResponseDTO>> getEducationByUserProfileId(@PathVariable Long userProfileId) {
        // TODO: Implement get education by user profile ID logic
        // List<EducationResponseDTO> responses = educationService.getEducationByUserProfileId(userProfileId);
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Update education entry
     * PUT /api/v1/education/{educationId}
     */
    @PutMapping("/{educationId}")
    public ResponseEntity<EducationResponseDTO> updateEducation(
            @PathVariable Long educationId,
            @Valid @RequestBody EducationRequestDTO request) {
        // TODO: Implement education update logic
        // EducationResponseDTO response = educationService.updateEducation(educationId, request);
        // return ResponseEntity.ok(response);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Delete education entry
     * DELETE /api/v1/education/{educationId}
     */
    @DeleteMapping("/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long educationId) {
        // TODO: Implement education deletion logic
        // educationService.deleteEducation(educationId);
        // return ResponseEntity.noContent().build();
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get education entries by institution
     * GET /api/v1/education/search/institution
     */
    @GetMapping("/search/institution")
    public ResponseEntity<List<EducationResponseDTO>> getEducationByInstitution(
            @RequestParam String institution,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        // TODO: Implement search education by institution logic
        // List<EducationResponseDTO> responses = educationService.getEducationByInstitution(institution, page, size);
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get education entries by degree
     * GET /api/v1/education/search/degree
     */
    @GetMapping("/search/degree")
    public ResponseEntity<List<EducationResponseDTO>> getEducationByDegree(
            @RequestParam String degree,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        // TODO: Implement search education by degree logic
        // List<EducationResponseDTO> responses = educationService.getEducationByDegree(degree, page, size);
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}