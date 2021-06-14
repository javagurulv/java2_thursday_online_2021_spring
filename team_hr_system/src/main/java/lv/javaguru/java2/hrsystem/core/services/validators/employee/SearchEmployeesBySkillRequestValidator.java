package lv.javaguru.java2.hrsystem.core.services.validators.employee;

import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.skill.SkillValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SearchEmployeesBySkillRequestValidator {

    @Autowired
    private SkillValidator skillValidator;

    public List<CoreError> validate(SearchEmployeesBySkillRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateSkillName(request).ifPresent(errors::add);
        validateSkillAdded(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateSkillName(SearchEmployeesBySkillRequest request) {
        if (request.getSkillName() == null || request.getSkillName().isEmpty()) {
            return Optional.of(new CoreError("skill name", "Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateSkillAdded(SearchEmployeesBySkillRequest request) {
        if (!skillValidator.skillExists(new Skill(request.getSkillName()))) {
            return Optional.of(new CoreError("this skill", "is not added yet!"));
        }
        return Optional.empty();
    }
}