package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LogInValidatorTest {

    private final LogInValidator validator = new LogInValidator();

    @Test
    public void shouldReturnErrorWhenUsernameIsNull() {
        LogInRequest request = new LogInRequest(null, "password");
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Username");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenPasswordIsNull() {
        LogInRequest request = new LogInRequest("username", null);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldSuccess() {
        LogInRequest request = new LogInRequest("username", "password");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}