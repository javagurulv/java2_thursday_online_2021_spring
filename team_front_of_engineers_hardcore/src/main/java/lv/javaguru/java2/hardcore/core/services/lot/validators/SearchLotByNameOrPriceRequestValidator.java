package lv.javaguru.java2.hardcore.core.services.lot.validators;


import lv.javaguru.java2.hardcore.core.requests.Ordering;
import lv.javaguru.java2.hardcore.core.requests.Paging;
import lv.javaguru.java2.hardcore.core.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class SearchLotByNameOrPriceRequestValidator {

    public List<CoreError> validate(SearchLotByNameOrPriceRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        if (request.getOrdering() != null) {
            validateOrderByInput(request.getOrdering()).ifPresent(errors::add);
            validateOrderDirectionInput(request.getOrdering()).ifPresent(errors::add);
            validateMandatoryOrderByBothInput(request.getOrdering()).ifPresent(errors::add);
            validateMandatoryOrderDirectionBothInput(request.getOrdering()).ifPresent(errors::add);
        }
        if (request.getPaging() != null) {
            validatePageNumber(request.getPaging()).ifPresent(errors::add);
            validatePageSize(request.getPaging()).ifPresent(errors::add);
            validateMandatoryPageNumber(request.getPaging()).ifPresent(errors::add);
            validateMandatoryPageSize(request.getPaging()).ifPresent(errors::add);
        }
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchLotByNameOrPriceRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getName()) && isEqualToZero(request.getPrice())) {
            errors.add(new CoreError("Name", "Must not be empty"));
            errors.add(new CoreError("Price", "Must not be equal to ZERO"));
        }
        return errors;

    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private boolean isEqualToZero(BigDecimal price) {
        return price == null || price.equals(BigDecimal.ZERO);
    }

    private Optional<CoreError> validateOrderByInput(Ordering ordering) {
        return (ordering.getOrderBy() != null && !(ordering.getOrderBy().equals("name") || ordering.getOrderBy().equals("price")))
                ? Optional.of(new CoreError("orderBy", "Must contain 'name' or 'price' only!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateOrderDirectionInput(Ordering ordering) {
        return (ordering.getOrderDirection() != null && !(ordering.getOrderDirection().equals("ASC") || ordering.getOrderDirection().equals("DESC")))
                ? Optional.of(new CoreError("orderDirection", "Must contain 'ASC' or 'DESC' only!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryOrderByBothInput(Ordering ordering) {
        return (ordering.getOrderBy() != null && ordering.getOrderDirection() == null)
                ? Optional.of(new CoreError("orderDirection", "Must not be empty!(Both cant be empty)"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryOrderDirectionBothInput(Ordering ordering) {
        return (ordering.getOrderDirection() != null && ordering.getOrderBy() == null)
                ? Optional.of(new CoreError("orderBy", "Must not be empty!(Both cant be empty)"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageNumber(Paging paging) {
        return (paging.getPageNumber() != null
                && paging.getPageNumber() <= 0)
                ? Optional.of(new CoreError("pageNumber", "Must be greater then 0!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageSize(Paging paging) {
        return (paging.getPageSize() != null
                && paging.getPageSize() <= 0)
                ? Optional.of(new CoreError("pageSize", "Must be greater then 0!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryPageNumber(Paging paging) {
        return (paging.getPageNumber() == null && paging.getPageSize() != null)
                ? Optional.of(new CoreError("pageNumber", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateMandatoryPageSize(Paging paging) {
        return (paging.getPageSize() == null && paging.getPageNumber() != null)
                ? Optional.of(new CoreError("pageSize", "Must not be empty!"))
                : Optional.empty();
    }


}
