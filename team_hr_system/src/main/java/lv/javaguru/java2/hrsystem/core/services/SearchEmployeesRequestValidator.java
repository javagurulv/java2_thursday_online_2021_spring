package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public class SearchEmployeesRequestValidator {

    public List<CoreError> validate(SearchEmployeesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchEmployeesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getName()) && isEmpty(request.getEmployeeTitle())) {
            errors.add(new CoreError("name", "Must not be empty!"));
            errors.add(new CoreError("title", "Must not be empty!"));
        }
        if (!isEmpty(request.getEmployeeTitle())) {
            validateTitle(request).ifPresent(errors::add);
        }
        return errors;
    }

    private Optional<CoreError> validateTitle(SearchEmployeesRequest request) {
        if (!isValidTitle(request.getEmployeeTitle())) {
            return Optional.of(new CoreError("invalid title - " + request.getEmployeeTitle(), " Must be selected from the pre-defined set!"));
        }
        return Optional.empty();
    }

    private boolean isEmpty(String field) {
        return field == null || field.isEmpty();
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