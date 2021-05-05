package lv.javaguru.java2.hardcore.services.user;

import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.LoginResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {


    @Mock private UserDatabase userDatabase;
    @Mock private LoginValidator validator;
    @Mock private User user;


    @InjectMocks
    private LoginService service;

    @Test
    public void loginError() {
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("test1", "test1"));
        LoginRequest request = new LoginRequest("test", "test");
        Mockito.when(validator.validate(request)).thenReturn(errors);
        LoginResponse response = service.execute(request);
        assertTrue(response.hasErrors());
    }


    @Test
    public void loginAccept() {

        LoginRequest request = new LoginRequest("test", "test");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        LoginResponse response = service.execute(request);
        User user = new User("test", "test");
        Mockito.verify(userDatabase).logIn(user);
        assertFalse(response.hasErrors());


    }

}