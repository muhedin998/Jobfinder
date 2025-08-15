package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.entities.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillDTOMapper {

    public SkillDTO apply(Skill entity, Long id) {
        if (entity == null) return null;
        
        return SkillDTO.builder()
                .skillId(entity.getId())
                .skillName(entity.getSkillName())
                .build();
    }
}
