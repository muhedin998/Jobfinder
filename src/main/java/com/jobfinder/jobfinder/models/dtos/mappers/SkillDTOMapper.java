package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.entities.Skill;

public enum SkillDTOMapper implements EntityMapper<SkillDTO, Skill, Long> {
    INSTANCE;

    @Override
    public SkillDTO apply(Skill entity, Long id) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setSkillId(entity.getId());
        skillDTO.setSkillName(entity.getSkillName());
        return skillDTO;
    }
}
