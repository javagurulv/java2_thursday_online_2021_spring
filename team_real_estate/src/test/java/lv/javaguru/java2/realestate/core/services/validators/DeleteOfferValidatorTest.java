package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteOfferValidatorTest {

    private final DeleteOfferValidator validator = new DeleteOfferValidator();

    @Test
    public void shouldReturnErrorWhenIDIsNull() {
        DeleteOfferRequest request = new DeleteOfferRequest(null);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "ID");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldSuccess() {
        DeleteOfferRequest request = new DeleteOfferRequest(0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}