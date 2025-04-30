package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.entities.Skill;
import com.jobfinder.jobfinder.repositories.SkillRepository;
import com.jobfinder.jobfinder.services.SkillService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.getReferenceById(skillId);
    }
}
