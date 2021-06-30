package lv.javaguru.java2.wasterestarant.core.services.products.validators;

import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

//AndrejsB
public class AddProductValidatorTest {
    private AddProductValidator validator = new AddProductValidator();

    @Test
    public void shouldReturnErrorWhenNameIsNull() throws ParseException {
        AddProductRequest request = new AddProductRequest(null, 1.0, 2.0,
                new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021"));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenPriceIsNull() throws ParseException {
        AddProductRequest request = new AddProductRequest("name", null, 2.0,
                new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021"));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Quantity");
        assertEquals(errors.get(0).getMessage(), "Must be a valid double value");
    }

    @Test
    public void shouldReturnErrorWhenQuantityIsNull() throws ParseException {
        AddProductRequest request = new AddProductRequest("name", 1.0, null,
                new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021"));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Price");
        assertEquals(errors.get(0).getMessage(), "Must be a valid double value");
    }

    @Test
    public void shouldReturnErrorWhenExpiryDateIsNull() {
        AddProductRequest request = new AddProductRequest("name", 1.0, 2.0, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Date");
        assertEquals(errors.get(0).getMessage(), "Must be a valid date");
    }

    @Test
    public void shouldSuccessfullyAdd() throws ParseException {
        AddProductRequest request = new AddProductRequest("name", 1.0, 2.0,
                new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021"));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}