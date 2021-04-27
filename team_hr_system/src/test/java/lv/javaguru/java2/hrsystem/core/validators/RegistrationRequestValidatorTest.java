package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.RegistrationRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.RegistrationValidator;
import lv.javaguru.java2.hrsystem.domain.UserRole;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class RegistrationRequestValidatorTest {

    RegistrationValidator validator = new RegistrationValidator();

    @Test
    public void shouldReturnErrorWhenUserRoleNullTest() {
        RegistrationRequest request = new RegistrationRequest( null, "null", "null", "null876@null.null", "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "user role");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenFirstNameNullTest() {
        RegistrationRequest request = new RegistrationRequest(UserRole.ADMIN, null, "null", "null876@null.null", "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "first name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenSecondNameNullTest() {
        RegistrationRequest request = new RegistrationRequest(UserRole.ADMIN, "null",null, "null876@null.null", "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "second name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenEmailNullTest() {
        RegistrationRequest request = new RegistrationRequest(UserRole.ADMIN, "null","null", null, "nul53l23");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "email");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPasswordNullTest() {
        RegistrationRequest request = new RegistrationRequest(UserRole.ADMIN,"null", "null", "null876@null.null", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }
}
