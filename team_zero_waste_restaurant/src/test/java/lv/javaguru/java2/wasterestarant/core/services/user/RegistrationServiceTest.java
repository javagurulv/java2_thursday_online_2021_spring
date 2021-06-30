package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.RegistrationResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.validators.RegistrationValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java2.wasterestarant.core.domain.UserRole.CLIENT;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
    @Mock
    private UserRepository repository;
    @Mock
    private RegistrationValidator validator;
    @InjectMocks
    RegistrationService service;

    @Test
    public void shouldSuccessfullyRegisterUser()  {
        RegistrationRequest request = new RegistrationRequest("admin", "admin", "admin@admin.lv", "admin");
        User user = new User(CLIENT,
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                request.getPassword());
        RegistrationResponse response = service.execute(request);
        verify(repository).save(user);
        assertFalse(response.hasErrors());
    }

    @Test
    public void shouldNotRegisterUser()  {
        RegistrationRequest request = new RegistrationRequest("admin", "admin", "admin@admin.lv", "");
        List<CoreError> errors = new ArrayList<>(List.of(new CoreError("Password", "Must not be empty")));
        when(validator.validate(request)).thenReturn(errors);
        RegistrationResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Password");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }
}