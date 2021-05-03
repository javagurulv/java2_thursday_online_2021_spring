package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class SearchEmployeesBySkillRequestValidator {

    public List<CoreError> validate(SearchEmployeesBySkillRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateSkillName(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateSkillName(SearchEmployeesBySkillRequest request) {
        if (request.getSkillName() == null || request.getSkillName().isEmpty()) {
            return Optional.of(new CoreError("skill name", "Must not be empty!"));
        }
        return Optional.empty();
    }
}