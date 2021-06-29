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
    public void shouldReturnErrorIfEmailIsEmpty() {
        ChangePasswordRequest request = new ChangePasswordRequest("");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorIfEmailDoNotContainSymbol() {
        ChangePasswordRequest request = new ChangePasswordRequest("admin");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must contain @ symbol");
    }

    @Test
    public void shouldReturnErrorIfEmailIsNotFound() {
        ChangePasswordRequest request = new ChangePasswordRequest("admin@admin.lv");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "admin@admin.lv is not found!");
    }

    @Test
    public void shouldReturnEmptyErrorList() {
        ChangePasswordRequest request = new ChangePasswordRequest("admin@admin.lv");
        when(repository.isEmailRegistered("admin@admin.lv")).thenReturn(true);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}