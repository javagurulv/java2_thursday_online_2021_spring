package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.jdbcrepos.UserRepository;
import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.RegisterUserResponse;
import lv.javaguru.java2.hrsystem.core.services.authorization.RegisterUserService;
import lv.javaguru.java2.hrsystem.core.services.validators.user.RegisterUserValidator;
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
public class RegisterUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RegisterUserValidator validator;

    @InjectMocks
    private RegisterUserService service;

    @Test
    public void shouldCallMethodRegisterUserTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN, "null",
                "null", "null@null.null", "nu2311ll");
        RegisterUserResponse response = service.execute(request);

        Mockito.verify(userRepository).registerUser(response.getUser());

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void shouldReturnErrorWhenAllFieldNullTest(){
        RegisterUserRequest request = new RegisterUserRequest(null, null,
                null, null, null);

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("user role", "Must not be empty!"));
            add(new CoreError("first name", "Must not be empty!"));
            add(new CoreError("second name", "Must not be empty!"));
            add(new CoreError("email", "Must not be empty!"));
            add(new CoreError("password", "Must not be empty!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 5).isTrue();
        assertThat(response.getErrors().contains(new CoreError("user role",
                "Must not be empty!"))).isTrue();
        assertThat(response.getErrors().contains(new CoreError("first name",
                "Must not be empty!"))).isTrue();
        assertThat(response.getErrors().contains(new CoreError("second name",
                "Must not be empty!"))).isTrue();
        assertThat(response.getErrors().contains(new CoreError("email",
                "Must not be empty!"))).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not be empty!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenEmailWrongFormatTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN, "null",
                "null", "null@", "nul2331l");

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("email", "Wrong format!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("email",
                "Wrong format!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenPasswordBeShortTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN, "null",
                "null", "null@null.null", "null");

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not be short!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not be short!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenPasswordContainOnlyNumberTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN,
                "null", "null", "null@null.null", "123456789");

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not contain only numbers or letters!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not contain only numbers or letters!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenPasswordContainOnlyLetterTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN,
                "null", "null", "null@null.null", "nullnullnull");

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not contain only numbers or letters!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not contain only numbers or letters!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }

    @Test
    public void shouldReturnErrorWhenPasswordContainSpaceTest() {
        RegisterUserRequest request = new RegisterUserRequest(UserRole.ADMIN,
                "null", "null", "null@null.null", "null2 13null");

        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("password", "Must not contain space!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(errors);

        RegisterUserResponse response = service.execute(request);

        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors().contains(new CoreError("password",
                "Must not contain space!"))).isTrue();

        Mockito.verifyNoInteractions(userRepository);
    }
}
