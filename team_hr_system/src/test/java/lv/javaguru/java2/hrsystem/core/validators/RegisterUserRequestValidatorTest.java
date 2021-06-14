package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.user.RegisterUserValidator;
import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class RegisterUserRequestValidatorTest {

    RegisterUserValidator validator = new RegisterUserValidator();

    @Test
    public void shouldReturnErrorWhenUserRoleNullTest() {
        RegisterUserRequest request = new RegisterUserRequest( null, "null", "null", "null876@null.null", "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "user role");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenFirstNameNullTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN, null, "null", "null876@null.null", "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "first name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenSecondNameNullTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN, "null",null, "null876@null.null", "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "second name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenEmailNullTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN, "null","null", null, "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "email");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPasswordNullTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN,"null", "null", "null876@null.null", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }
}
