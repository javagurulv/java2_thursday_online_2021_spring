package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.requests.lot.Ordering;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


}
