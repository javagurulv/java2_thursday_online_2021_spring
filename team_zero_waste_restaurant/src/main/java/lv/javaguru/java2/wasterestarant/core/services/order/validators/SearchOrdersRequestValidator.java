package lv.javaguru.java2.wasterestarant.core.services.order.validators;

import lv.javaguru.java2.wasterestarant.core.requests.order.SearchOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchOrdersRequestValidator {

    public List<CoreError> validate(SearchOrdersRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchOrdersRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getClientID() == null && request.getOrderDate() == null) {
            errors.add(new CoreError("User ID", "Must not be empty!"));
            //errors.add(new CoreError("Order date", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
