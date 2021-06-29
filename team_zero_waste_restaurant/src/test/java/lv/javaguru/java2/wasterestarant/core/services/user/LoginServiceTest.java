package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.LoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
    @Mock
    private UserRepository repository;
    @Mock
    private LoginValidator validator;
    @InjectMocks
    LoginService service;

    @Test
    public void shouldLoginUser()  {
        LoginRequest request = new LoginRequest("admin@admin.lv", "admin");
        when(repository.isUserRegistered("admin@admin.lv", "admin")).thenReturn(true);
        LoginResponse response = service.execute(request);
        assertFalse(response.hasErrors());

    }

    @Test
    public void shouldNotLoginUser()  {

    }

}