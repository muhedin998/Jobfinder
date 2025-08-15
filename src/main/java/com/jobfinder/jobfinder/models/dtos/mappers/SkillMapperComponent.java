package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.entities.Skill;
import com.jobfinder.jobfinder.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillMapperComponent {

    @Autowired
    private SkillService skillService;

    public Skill toEntity(SkillDTO dto) {
        if (dto == null) return null;
        
        if (dto.getSkillId() != null) {
            Skill skill = skillService.getSkillById(dto.getSkillId());
            skill.setSkillName(dto.getSkillName());
            return skill;
        } else {
            Skill skill = new Skill();
            skill.setSkillName(dto.getSkillName());
            return skill;
        }
    }

    public SkillDTO toDto(Skill entity) {
        if (entity == null) return null;
        
        SkillDTO dto = new SkillDTO();
        dto.setSkillId(entity.getId());
        dto.setSkillName(entity.getSkillName());
        return dto;
    }
}