package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddSkillResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddSkillRequestValidator;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.Skill;

import java.util.List;

public class AddSkillService {
    private Database database;
    private AddSkillRequestValidator validator;

    public AddSkillService(Database database, AddSkillRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public AddSkillResponse execute(AddSkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddSkillResponse(errors);
        }
        boolean added = database.addSkill(new Employee(request.getEmployeeId()), new Skill(request.getSkillName()));
        return new AddSkillResponse(added);
    }
}