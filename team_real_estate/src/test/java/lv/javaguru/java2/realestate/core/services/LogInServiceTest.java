package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.validators.LogInValidator;
import lv.javaguru.java2.realestate.matchers.UserMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public class LogInServiceTest {

    @Mock
    private UserRepository database;
    @Mock
    private LogInValidator validator;
    @InjectMocks
    private LogInService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        LogInRequest request = new LogInRequest(null, "password");
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("username", "Must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        LogInResponse response = service.execute(request);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "username");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldLogIn() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        LogInRequest request = new LogInRequest("username", "password");
        LogInResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).logIn(
                argThat(new UserMatcher("username", "password")));

    }
}
