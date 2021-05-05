package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import lv.javaguru.java2.hrsystem.core.services.AuthorizeUserService;
import lv.javaguru.java2.hrsystem.core.services.GetAllUsersService;
import lv.javaguru.java2.hrsystem.core.services.RegisterUserService;
import lv.javaguru.java2.hrsystem.dependency_injection.ApplicationContext;
import lv.javaguru.java2.hrsystem.dependency_injection.DIApplicationContextBuilder;
import lv.javaguru.java2.hrsystem.domain.User;
import lv.javaguru.java2.hrsystem.domain.UserRole;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTestAuthorizeUser {

    private ApplicationContext context = new DIApplicationContextBuilder().build("lv.javaguru.java2.hrsystem");

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

    private RegisterUserService registerUserService() {
        return context.getBean(RegisterUserService.class);
    }

    private AuthorizeUserService authorizeUserService() {
        return context.getBean(AuthorizeUserService.class);
    }

    private GetAllUsersService getAllUsersService() {
        return context.getBean(GetAllUsersService.class);
    }
}
