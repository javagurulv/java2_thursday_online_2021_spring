package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.GetAllExistingSkillsRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllExistingSkillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllExistingSkillsService {

    @Autowired
    private Database database;

    public GetAllExistingSkillsResponse execute(GetAllExistingSkillsRequest request) {
        List<Skill> skills = database.getAllExistingSkills();
        return new GetAllExistingSkillsResponse(skills);
    }
}