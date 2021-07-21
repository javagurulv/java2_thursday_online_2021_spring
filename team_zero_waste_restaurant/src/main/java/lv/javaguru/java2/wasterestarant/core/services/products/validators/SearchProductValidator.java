package lv.javaguru.java2.wasterestarant.core.services.products.validators;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.product.*;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SearchProductValidator {

    public List<CoreError> validate(SearchProductRequest request) {
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

    private List<CoreError> validateSearchFields(SearchProductRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getNameToSearch())) {
            errors.add(new CoreError("name", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private Optional<CoreError> validateOrderBy(Ordering ordering) {
        return (!isEmpty(ordering.getOrderBy())
                && !(ordering.getOrderBy().equals("BBD") || ordering.getOrderBy().equals("Q")))
                ? Optional.of(new CoreError("ordering By", "Must contain only 'BBD'" +
                " or 'Q'!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateOrderDirection(Ordering ordering) {
        return (!isEmpty(ordering.getOrderDirection())
                && !(ordering.getOrderDirection().equals("ASC") || ordering.getOrderDirection().equals("DESC")))
                ? Optional.of(new CoreError("ordering direction", "Must contain only 'ASC' or 'DESC'!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryOrderBy(Ordering ordering) {
        return (!isEmpty(ordering.getOrderDirection()) && ordering.getOrderBy() == null)
                ? Optional.of(new CoreError("ordering By", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryOrderDirection(Ordering ordering) {
        return (!isEmpty(ordering.getOrderBy()) && ordering.getOrderDirection() == null)
                ? Optional.of(new CoreError("ordering direction", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageNumber(Paging paging) {
        return (paging.getPageNumber() != null
                && paging.getPageNumber() <= 0)
                ? Optional.of(new CoreError("Page number", "Must be greater then 0!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageSize(Paging paging) {
        return (paging.getPageSize() != null
                && paging.getPageSize() <= 0)
                ? Optional.of(new CoreError("Page size", "Must be greater then 0!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryPageNumber(Paging paging) {
        return (paging.getPageNumber() == null
                && paging.getPageSize() != 0)
                ? Optional.of(new CoreError("Page number", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryPageSize(Paging paging) {
        return (paging.getPageSize() == null
                && paging.getPageNumber() != null)
                ? Optional.of(new CoreError("Page size", "Must not be empty!"))
                : Optional.empty();
    }
}
