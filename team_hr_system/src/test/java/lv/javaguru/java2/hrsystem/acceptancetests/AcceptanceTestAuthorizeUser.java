package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.config.HumanResourcesSystemConfiguration;
import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import lv.javaguru.java2.hrsystem.core.requests.*;
import lv.javaguru.java2.hrsystem.core.domain.*;
import lv.javaguru.java2.hrsystem.core.services.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTestAuthorizeUser {

    private ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new AnnotationConfigApplicationContext(HumanResourcesSystemConfiguration.class);
    }

    private RegisterUserService registerUserService() {
        return appContext.getBean(RegisterUserService.class);
    }

    private AuthorizeUserService authorizeUserService() {
        return appContext.getBean(AuthorizeUserService.class);
    }

    private GetAllUsersService getAllUsersService() {
        return appContext.getBean(GetAllUsersService.class);
    }

    @Test
    public void shouldReturnAuthorizeUser() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(UserRole.ADMIN,
                "null", "null", "null@null.null", "null123456");
        AuthorizeUserRequest authorizeUserRequest = new AuthorizeUserRequest(registerUserRequest.getEmail(),
                registerUserRequest.getPassword());

        registerUserService().execute(registerUserRequest);
        authorizeUserService().execute(authorizeUserRequest);

        GetAllUsersResponse getAllUsersResponse = getAllUsersService().execute();

        assertThat(getAllUsersResponse.getUsers().size() >= 1).isTrue();

        User expectedUser = new User(UserRole.ADMIN,
                "null", "null", "null@null.null", "null123456");
        expectedUser.setId(1L);

        assertThat(getAllUsersResponse.getUsers().get(0)).isEqualTo(expectedUser);
    }
}
