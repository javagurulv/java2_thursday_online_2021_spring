package lv.javaguru.java2.wasterestarant.core.services.dish.validators;


import lv.javaguru.java2.wasterestarant.core.requests.dish.AddDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//Andris
public class AddDishValidatorTest {

    private AddDishValidator validator = new AddDishValidator();

    @Test
    public void shouldReturnErrorWhenNameIsNull() {
        AddDishRequest request = new AddDishRequest(null, "desc", "soup", 1.0, 2.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenDescriptionIsNull() {
        AddDishRequest request = new AddDishRequest("name", null, "soup", 1.0, 2.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Description");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenTypeIsNull() {
        AddDishRequest request = new AddDishRequest("name", "desc", null, 1.0, 2.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenWeightIsNull() {
        AddDishRequest request = new AddDishRequest("name", "desc", "soup", null, 2.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Weight");
        assertEquals(errors.get(0).getMessage(), "Must be a valid double value");
    }

    @Test
    public void shouldReturnErrorWhenPriceIsNull() {
        AddDishRequest request = new AddDishRequest("name", "desc", "soup", 1.0, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Price");
        assertEquals(errors.get(0).getMessage(), "Must be a valid double value");
    }

    @Test
    public void shouldReturnErrorsWhenAllFieldsAreNull() {
        AddDishRequest request = new AddDishRequest(null, null, null, null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 5);
    }

    @Test
    public void shouldSuccess() {
        AddDishRequest request = new AddDishRequest("name", "desc", "soup", 1.0, 2.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}
