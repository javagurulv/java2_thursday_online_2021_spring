package lv.javaguru.java2.wasterestarant.core.services.dish.validators;

import lv.javaguru.java2.wasterestarant.core.requests.dish.RemoveDishRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

// AndrejsB
public class RemoveDishValidatorTest {

    private RemoveDishValidator validator = new RemoveDishValidator();

    @Test
    public void shouldReturnErrorWhenNameIsNull() {
        RemoveDishRequest request = new RemoveDishRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldRemoveDish() {
        RemoveDishRequest request = new RemoveDishRequest("name");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}