package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteUserValidatorTest {

    private final DeleteUserValidator validator = new DeleteUserValidator();

    @Test
    public void shouldReturnErrorWhenUsernameIsNull() {
        DeleteUserRequest request = new DeleteUserRequest(null, "password");
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Username");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenPasswordIsNull() {
        DeleteUserRequest request = new DeleteUserRequest("username", null);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldSuccess() {
        DeleteUserRequest request = new DeleteUserRequest("username", "password");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}