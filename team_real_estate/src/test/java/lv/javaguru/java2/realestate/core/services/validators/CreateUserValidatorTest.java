package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateUserValidatorTest {

    private final CreateUserValidator validator = new CreateUserValidator();

    @Test
    public void shouldReturnErrorWhenUsernameIsNull() {
        CreateUserRequest request = new CreateUserRequest(null, "password");
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Username");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenPasswordIsNull() {
        CreateUserRequest request = new CreateUserRequest("username", null);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldSuccess() {
        CreateUserRequest request = new CreateUserRequest("username", "password");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}