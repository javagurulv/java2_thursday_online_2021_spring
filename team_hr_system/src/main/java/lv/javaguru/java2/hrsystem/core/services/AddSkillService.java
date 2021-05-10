package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.AddSkillRequestValidator;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.*;

import java.util.List;

@DIComponent
public class AddSkillService {

   @DIDependency private Database database;
   @DIDependency private AddSkillRequestValidator validator;

   public AddSkillResponse execute(AddSkillRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddSkillResponse(errors);
        }
        boolean added = database.addSkill(new Employee(request.getEmployeeId()), new Skill(request.getSkillName()));
        return new AddSkillResponse(added);
    }
}