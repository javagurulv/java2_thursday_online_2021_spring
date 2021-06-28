package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationValidatorTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private RegistrationValidator validator;

    @Test
    public void shouldReturnErrorIfNameIsEmpty() {
        RegistrationRequest request = new RegistrationRequest("", "admin", "admin@admin.lv", "admin");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorIfSurnameIsEmpty() {
        RegistrationRequest request = new RegistrationRequest("admin", "", "admin@admin.lv", "admin");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Surname");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorsIfEmailIsNotCorrectlyFilledIn() {
    }

    @Test
    public void shouldReturnErrorsIfPasswordIsNotCorrectlyFilledIn() {
    }
}