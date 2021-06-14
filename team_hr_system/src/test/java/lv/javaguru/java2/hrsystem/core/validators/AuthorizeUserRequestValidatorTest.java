package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.user.AuthorizeUserValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorizeUserRequestValidatorTest {

    AuthorizeUserValidator validator = new AuthorizeUserValidator();

    @Test
    public void shouldReturnErrorsWhenEmailNullTest() {
        AuthorizeUserRequest request = new AuthorizeUserRequest(null, "nullll");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "email");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }

    @Test
    public void shouldReturnErrorsWhenPasswordNullTest() {
        AuthorizeUserRequest request = new AuthorizeUserRequest("null", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }
}
