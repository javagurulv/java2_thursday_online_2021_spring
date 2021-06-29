package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangePasswordRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChangePasswordValidatorTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private ChangePasswordValidator validator;

    @Test
    public void shouldReturnErrorsIfEmailIsEmpty() {
        ChangePasswordRequest request = new ChangePasswordRequest("");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 3);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
        assertEquals(errors.get(1).getField(), "E-mail");
        assertEquals(errors.get(1).getMessage(), "Must contain @ symbol");
        assertEquals(errors.get(2).getField(), "E-mail");
        assertEquals(errors.get(2).getMessage(), " is not found!");
    }

    @Test
    public void shouldReturnErrorIfEmailIsNotCorrectlyFilledIn1() {
        ChangePasswordRequest request = new ChangePasswordRequest("admin");
        when(repository.isEmailRegistered("admin")).thenReturn(false);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must contain @ symbol");
        assertEquals(errors.get(1).getField(), "E-mail");
        assertEquals(errors.get(1).getMessage(), "admin is not found!");
    }

    @Test
    public void shouldReturnErrorIfEmailIsNotCorrectlyFilledIn2() {
        ChangePasswordRequest request = new ChangePasswordRequest("admin@admin.lv");
        when(repository.isEmailRegistered("admin@admin.lv")).thenReturn(false);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "admin@admin.lv is not found!");
    }
}