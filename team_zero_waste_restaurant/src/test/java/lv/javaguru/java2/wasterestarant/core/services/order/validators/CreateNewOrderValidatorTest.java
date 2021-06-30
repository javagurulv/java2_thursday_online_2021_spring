package lv.javaguru.java2.wasterestarant.core.services.order.validators;

import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class CreateNewOrderValidatorTest {

    private CreateNewOrderValidator validator = new CreateNewOrderValidator();

    @Test
    public void shouldReturnErrorWhenClientIDIsNull() throws ParseException {
        CreateNewOrderRequest request = new CreateNewOrderRequest(null,
                new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2021"));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Client ID");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenDateIsNull() {
        CreateNewOrderRequest request = new CreateNewOrderRequest(1L,
                null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Date");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

}