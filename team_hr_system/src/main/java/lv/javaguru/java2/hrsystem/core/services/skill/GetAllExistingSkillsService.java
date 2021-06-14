package lv.javaguru.java2.hrsystem.core.services.skill;

import lv.javaguru.java2.hrsystem.core.database.ORMSkillRepository;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllExistingSkillsService {

    @Autowired
   // private SkillRepository skillRepository;
    private ORMSkillRepository ormSkillRepository;

    public GetAllExistingSkillsResponse execute(GetAllExistingSkillsRequest request) {
        List<Skill> skills = ormSkillRepository.getAllExistingSkills();
        return new GetAllExistingSkillsResponse(skills);
    }
}