package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.requests.Ordering;
import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@DIComponent
public class SearchEmployeesRequestValidator {

    public List<CoreError> validate(SearchEmployeesRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));

        if (request.getOrdering() != null) {
            validateOrderBy(request.getOrdering()).ifPresent(errors::add);
            validateOrderDirection(request.getOrdering()).ifPresent(errors::add);
            validateMandatoryOrderBy(request.getOrdering()).ifPresent(errors::add);
            validateMandatoryOrderDirection(request.getOrdering()).ifPresent(errors::add);
        }

        if (request.getPaging() != null) {
            validatePageNumber(request.getPaging()).ifPresent(errors::add);
            validatePageSize(request.getPaging()).ifPresent(errors::add);
            validateMandatoryPageNumber(request.getPaging()).ifPresent(errors::add);
            validateMandatoryPageSize(request.getPaging()).ifPresent(errors::add);
        }

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

    private Optional<CoreError> validateOrderBy(Ordering ordering) {
        return (ordering.getOrderBy() != null
                && !(ordering.getOrderBy().equals("name") || ordering.getOrderBy().equals("title")))
                ? Optional.of(new CoreError("orderBy", "Must contain 'name' or 'title' only!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateOrderDirection(Ordering ordering) {
        return (ordering.getOrderDirection() != null
                && !(ordering.getOrderDirection().equals("ASCENDING") || ordering.getOrderDirection().equals("DESCENDING")))
                ? Optional.of(new CoreError("orderDirection", "Must contain 'ASCENDING' or 'DESCENDING' only!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryOrderBy(Ordering ordering) {
        return (ordering.getOrderDirection() != null && ordering.getOrderBy() == null)
                ? Optional.of(new CoreError("orderBy", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryOrderDirection(Ordering ordering) {
        return (ordering.getOrderBy() != null && ordering.getOrderDirection() == null)
                ? Optional.of(new CoreError("orderDirection", "Must not be empty!"))
                : Optional.empty();
    }


    private Optional<CoreError> validatePageNumber(Paging paging) {
        return (paging.getPageNumber() != null
                && paging.getPageNumber() <= 0
                ? Optional.of(new CoreError("pageNumber", "Must be greater then 0!"))
                : Optional.empty());
    }

    private Optional<CoreError> validatePageSize(Paging paging) {
        return (paging.getPageSize() != null && paging.getPageSize() <= 0
                ? Optional.of(new CoreError("pageSize", "Must be greater then 0!"))
                : Optional.empty());
    }

    private Optional<CoreError> validateMandatoryPageNumber(Paging paging) {
        return (paging.getPageNumber() == null && paging.getPageSize() != null
                ? Optional.of(new CoreError("pageNumber", "Must not be empty!"))
                : Optional.empty());
    }

    private Optional<CoreError> validateMandatoryPageSize(Paging paging) {
        return (paging.getPageSize() == null && paging.getPageNumber() != null
                ? Optional.of(new CoreError("pageSize", "Must not be empty!"))
                : Optional.empty());
    }
}