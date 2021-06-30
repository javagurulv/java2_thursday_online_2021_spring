package lv.javaguru.java2.wasterestarant.core.services.user.validators;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
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
public class ChangeUserRoleValidatorTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private ChangeUserRoleValidator validator;

    @Test
    public void shouldReturnErrorIfUserRoleIsEmpty() {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(null, "admin@admin.lv");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "User role");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorIfEmailIsEmpty() {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(UserRole.ADMIN, "");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorIfEmailDoNotContainSymbol() {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(UserRole.ADMIN, "admin");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must contain @ symbol");
    }

    @Test
    public void shouldReturnErrorIfEmailIsNotFound() {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(UserRole.ADMIN,"admin@admin.lv");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "admin@admin.lv is not registered in the system!");
    }

    @Test
    public void shouldReturnEmptyErrorList() {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(UserRole.ADMIN,"admin@admin.lv");
        when(repository.isEmailRegistered(request.getEmail())).thenReturn(true);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}