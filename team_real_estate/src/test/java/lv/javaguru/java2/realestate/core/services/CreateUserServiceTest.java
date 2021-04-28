package lv.javaguru.java2.realestate.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateUserValidator;
import lv.javaguru.java2.realestate.matchers.UserMatcher;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {

    @Mock
    private Database database;
    @Mock
    private CreateUserValidator validator;
    @InjectMocks
    private CreateUserService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        CreateUserRequest request = new CreateUserRequest(null, "password");
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("username", "Must not be empty !"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        CreateUserResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "username");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty !");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldCreateUserInDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        CreateUserRequest request = new CreateUserRequest("username", "password");
        CreateUserResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).createAccount(
                argThat(new UserMatcher("username", "password")));
    }
}