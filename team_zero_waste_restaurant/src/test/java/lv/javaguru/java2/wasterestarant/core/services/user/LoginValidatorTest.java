package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LoginValidatorTest {

    @Mock private UserRepository repository;

    @InjectMocks private LoginValidator validator;

    @Test
    public void shouldReturnErrorsIfEmailFieldIsNotCorrectlyFilledIn() {
        LoginRequest request = new LoginRequest("", "password");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 3);
        assertEquals(errors.get(0).getField(), "Email");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
        assertEquals(errors.get(1).getField(), "Email");
        assertEquals(errors.get(1).getMessage(), "Email must contain @ symbol");
        assertEquals(errors.get(2).getField(), "Email and Password");
        assertEquals(errors.get(2).getMessage(), "User is not registered!");
    }

    @Test
    public void shouldReturnErrorIfPasswordIsEmpty() {
    }

    @Test
    public void shouldReturnErrorIfUserIsNotRegistered() {
    }

    @Test
    public void shouldReturnEmptyErrorList() {
    }
}