package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.LoginRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.LoginValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginRequestValidatorTest {

    LoginValidator validator = new LoginValidator();

    @Test
    public void shouldReturnErrorsWhenEmailNullTest() {
        LoginRequest request = new LoginRequest(null, "nullll");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "email");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }

    @Test
    public void shouldReturnErrorsWhenPasswordNullTest() {
        LoginRequest request = new LoginRequest("null", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }
}
