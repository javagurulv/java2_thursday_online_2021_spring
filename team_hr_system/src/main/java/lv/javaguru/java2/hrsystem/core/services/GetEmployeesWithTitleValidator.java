package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.GetEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public class GetEmployeesWithTitleValidator {

    public List<CoreError> validate(GetEmployeesByTitleRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateTitle(request).ifPresent(errors::add);
        return errors;
    }

    public Optional<CoreError> validateTitle(GetEmployeesByTitleRequest request) {
        if (request.getEmployeeTitle() == null || request.getEmployeeTitle().isEmpty()) {
            return Optional.of(new CoreError("employee title", "Must not be empty!"));
        } else if (!isValidTitle(request.getEmployeeTitle())) {
            return Optional.of(new CoreError("invalid title - " + request.getEmployeeTitle(), " Must be selected from the pre-defined set!"));
        }
        return Optional.empty();
    }

    private boolean isValidTitle(String title) {
        EnumSet<EmployeeTitle> titles = EnumSet.allOf(EmployeeTitle.class);
        boolean valid;
        try {
            valid = titles.contains(EmployeeTitle.valueOf(title));
        } catch (IllegalArgumentException e) {
            valid = false;
        }
        return valid;
    }
}