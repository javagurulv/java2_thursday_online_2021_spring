package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.SkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllExistingSkillsService {

    @Autowired
    private SkillRepository skillRepository;

    public GetAllExistingSkillsResponse execute(GetAllExistingSkillsRequest request) {
        List<Skill> skills = skillRepository.getAllExistingSkills();
        return new GetAllExistingSkillsResponse(skills);
    }
}