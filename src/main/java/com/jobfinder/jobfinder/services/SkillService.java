package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.entities.Skill;

public interface SkillService {
    Skill getSkillById(Long skillId);
}
