package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddSkillRequestValidator;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddSkillService {

    @Autowired
    private Database database;
    @Autowired
    private AddSkillRequestValidator validator;


    public AddSkillResponse execute(AddSkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddSkillResponse(errors);
        }
        boolean added = database.addSkill(new Employee(request.getEmployeeId()), new Skill(request.getSkillName()));
        return new AddSkillResponse(added);
    }
}