package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.jdbcrepos.UserRepository;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizeUserResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.authorization.AuthorizeUserService;
import lv.javaguru.java2.hrsystem.core.services.validators.user.AuthorizeUserValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizeUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthorizeUserValidator validator;

    @InjectMocks
    private AuthorizeUserService service;

    @Test
    public void shouldCallMethodAuthorizeUserTest() {
        AuthorizeUserRequest request = new AuthorizeUserRequest("null@null.null", "null213null");
        AuthorizeUserResponse response = service.execute(request);

        Mockito.verify(userRepository).authorizeUser(request.getEmail(), request.getPassword());

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void shouldReturnErrorWhenAllFieldNullTest(){
        AuthorizeUserRequest request = new AuthorizeUserRequest(null, null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Must not be empty!"));
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        AuthorizeUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 2).isTrue();
        assertThat(response.getErrors().contains(new CoreError("email",
                "Must not be empty!"))).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenEmailNullTest(){
        AuthorizeUserRequest request = new AuthorizeUserRequest(null, "null");

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Must not be empty!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        AuthorizeUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("email",
                "Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenPasswordNullTest(){
        AuthorizeUserRequest request = new AuthorizeUserRequest("null", null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        AuthorizeUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }
}
