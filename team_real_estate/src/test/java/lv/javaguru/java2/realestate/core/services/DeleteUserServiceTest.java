package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.DeleteUserValidator;
import lv.javaguru.java2.realestate.matchers.UserMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public class DeleteUserServiceTest {

    @Mock
    private UserRepository database;
    @Mock
    private DeleteUserValidator validator;
    @InjectMocks
    private DeleteUserService service;

    @Test
    public void shouldReturnErrorWhenWhenValidationFails() {
        DeleteUserRequest request = new DeleteUserRequest(null, "password");
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("username", "Must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        DeleteUserResponse response = service.execute(request);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "username");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldDeleteUserFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        DeleteUserRequest request = new DeleteUserRequest("username", "password");
        DeleteUserResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).deleteUser(argThat(new UserMatcher("username", "password")));


    }
}
