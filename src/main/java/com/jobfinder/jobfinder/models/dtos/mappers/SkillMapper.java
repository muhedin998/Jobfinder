package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.entities.Skill;
import com.jobfinder.jobfinder.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;

public enum SkillMapper implements DTOMapper<Skill, SkillDTO> {
    INSTANCE;

    @Autowired
    private SkillService skillService;

    @Override
    public Skill apply(SkillDTO dto) {
        Skill skill = skillService.getSkillById(dto.getSkillId());
        skill.setSkillName(dto.getSkillName());
        return skill;
    }
}
