package lv.javaguru.java2.hrsystem.core.services.validators.skill;

import lv.javaguru.java2.hrsystem.core.database.ORMSkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillValidator {

    @Autowired
    private ORMSkillRepository ormSkillRepository;

    public boolean skillExists(Skill skill) {
        return ormSkillRepository.getAllExistingSkills()
                .stream()
                .anyMatch(s -> s.getSkillName().equals(skill.getSkillName()));
    }
}