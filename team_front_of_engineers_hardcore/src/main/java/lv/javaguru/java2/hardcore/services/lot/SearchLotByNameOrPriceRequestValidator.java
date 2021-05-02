package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SearchLotByNameOrPriceRequestValidator {

    public List<CoreError> validate(SearchLotByNameOrPriceRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    public List<CoreError> validateSearchFields(SearchLotByNameOrPriceRequest request) {
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
}
