package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizationRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AuthorizationValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginRequestValidatorTest {

    AuthorizationValidator validator = new AuthorizationValidator();

    @Test
    public void shouldReturnErrorsWhenEmailNullTest() {
        AuthorizationRequest request = new AuthorizationRequest(null, "nullll");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "email");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }

    @Test
    public void shouldReturnErrorsWhenPasswordNullTest() {
        AuthorizationRequest request = new AuthorizationRequest("null", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }
}
