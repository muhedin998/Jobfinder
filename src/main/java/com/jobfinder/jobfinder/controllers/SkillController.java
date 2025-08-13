package com.jobfinder.jobfinder.controllers;

import com.jobfinder.jobfinder.models.dtos.request.SkillRequestDTO;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    // TODO: Inject SkillService here
    // @Autowired
    // private SkillService skillService;

    /**
     * Create a new skill
     * POST /api/v1/skills
     */
    @PostMapping
    public ResponseEntity<SkillDTO> createSkill(@Valid @RequestBody SkillRequestDTO request) {
        // TODO: Implement skill creation logic
        // SkillDTO response = skillService.createSkill(request);
        // return new ResponseEntity<>(response, HttpStatus.CREATED);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get skill by ID
     * GET /api/v1/skills/{skillId}
     */
    @GetMapping("/{skillId}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable Long skillId) {
        // TODO: Implement get skill by ID logic
        // SkillDTO response = skillService.getSkillById(skillId);
        // return ResponseEntity.ok(response);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get all skills
     * GET /api/v1/skills
     */
    @GetMapping
    public ResponseEntity<List<SkillDTO>> getAllSkills() {
        // TODO: Implement get all skills logic
        // List<SkillDTO> responses = skillService.getAllSkills();
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Update skill
     * PUT /api/v1/skills/{skillId}
     */
    @PutMapping("/{skillId}")
    public ResponseEntity<SkillDTO> updateSkill(
            @PathVariable Long skillId,
            @Valid @RequestBody SkillRequestDTO request) {
        // TODO: Implement skill update logic
        // SkillDTO response = skillService.updateSkill(skillId, request);
        // return ResponseEntity.ok(response);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Delete skill
     * DELETE /api/v1/skills/{skillId}
     */
    @DeleteMapping("/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long skillId) {
        // TODO: Implement skill deletion logic
        // skillService.deleteSkill(skillId);
        // return ResponseEntity.noContent().build();
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Search skills by name
     * GET /api/v1/skills/search
     */
    @GetMapping("/search")
    public ResponseEntity<List<SkillDTO>> searchSkills(@RequestParam String name) {
        // TODO: Implement skill search logic
        // List<SkillDTO> responses = skillService.searchSkills(name);
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get popular skills (most used)
     * GET /api/v1/skills/popular
     */
    @GetMapping("/popular")
    public ResponseEntity<List<SkillDTO>> getPopularSkills(
            @RequestParam(defaultValue = "10") int limit) {
        // TODO: Implement get popular skills logic
        // List<SkillDTO> responses = skillService.getPopularSkills(limit);
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get skills by category/type
     * GET /api/v1/skills/by-type/{type}
     */
    @GetMapping("/by-type/{type}")
    public ResponseEntity<List<SkillDTO>> getSkillsByType(@PathVariable String type) {
        // TODO: Implement get skills by type logic
        // List<SkillDTO> responses = skillService.getSkillsByType(type);
        // return ResponseEntity.ok(responses);
        
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}