package lv.javaguru.java2.wasterestarant.core.services.order.validators;

import lv.javaguru.java2.wasterestarant.core.requests.order.SearchOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class SearchOrdersRequestValidatorTest {

    SearchOrdersRequestValidator validator = new SearchOrdersRequestValidator();

    @Test
    public void shouldNotReturnErrorsWhenFieldsAreProvided() {
        SearchOrdersRequest request = new SearchOrdersRequest(1L, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchOrdersRequest request = new SearchOrdersRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "User ID");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
//        assertEquals(errors.get(1).getField(), "Order date");
//        assertEquals(errors.get(1).getMessage(), "Must not be empty!");
    }

}