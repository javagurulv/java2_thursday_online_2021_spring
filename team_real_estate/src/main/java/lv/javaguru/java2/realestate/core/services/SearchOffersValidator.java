package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchOffersValidator {

    public List<CoreError> validate(SearchOffersRequest request) {
        List<CoreError> errors = new ArrayList<>(validateSearchFields(request));

        if (request.getOrdering() != null) {
            validateOrderBy(request.getOrdering()).ifPresent(errors::add);
            validateOrderDirection(request.getOrdering()).ifPresent(errors::add);
            validateMandatoryOrderBy(request.getOrdering()).ifPresent(errors::add);
            validateMandatoryOrderDirection(request.getOrdering()).ifPresent(errors::add);
        }
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchOffersRequest request) {
        List<CoreError> errors = new ArrayList<>();

        if (isEmptyString(request.getOfferType())
                && isEmptyString(request.getOfferCategory())
                && isEmptyDouble(request.getPrice())) {
            errors.add(new CoreError("Type", "Must not be empty!"));
            errors.add(new CoreError("Category", "Must not be empty!"));
            errors.add(new CoreError("Price", "Must not be empty"));
        }
        return errors;
    }

    private boolean isEmptyString(String aString) {
        return aString == null || aString.isEmpty();
    }

    private boolean isEmptyDouble(Double aDouble) {
        return aDouble == null || aDouble == 0.0;
    }

    private Optional<CoreError> validateOrderBy(Ordering ordering) {
        return (ordering.getOrderBy() != null
                && !(ordering.getOrderBy().equals("author") || ordering.getOrderBy().equals("title")))
                ? Optional.of(new CoreError("orderBy", "Must contain 'author' or 'title' only!"))
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
}
