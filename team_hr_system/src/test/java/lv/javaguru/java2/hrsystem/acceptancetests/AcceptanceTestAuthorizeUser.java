//package lv.javaguru.java2.hrsystem.acceptancetests;
//
//import lv.javaguru.java2.hrsystem.DatabaseCleaner;
//import lv.javaguru.java2.hrsystem.config.HRSystemConfiguration;
//import lv.javaguru.java2.hrsystem.core.domain.User;
//import lv.javaguru.java2.hrsystem.core.domain.UserRole;
//import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
//import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
//import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
//import lv.javaguru.java2.hrsystem.core.services.user.AuthorizeUserService;
//import lv.javaguru.java2.hrsystem.core.services.user.GetAllUsersService;
//import lv.javaguru.java2.hrsystem.core.services.user.RegisterUserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class AcceptanceTestAuthorizeUser {
//
//    private ApplicationContext context;
//
//    @Before
//    public void setup() {
//        context = new AnnotationConfigApplicationContext(HRSystemConfiguration.class);
//        databaseCleaner().clean();
//    }
//
//    @Test
//    public void shouldReturnAuthorizeUser() {
//        RegisterUserRequest registerUserRequest = new RegisterUserRequest(UserRole.ADMIN,
//                "null", "null", "null@null.null", "null123456");
//        AuthorizeUserRequest authorizeUserRequest = new AuthorizeUserRequest(registerUserRequest.getEmail(),
//                registerUserRequest.getPassword());
//
//        registerUserService().execute(registerUserRequest);
//        authorizeUserService().execute(authorizeUserRequest);
//
//        GetAllUsersResponse getAllUsersResponse = getAllUsersService().execute();
//
//        assertThat(getAllUsersResponse.getUsers().size() >= 1).isTrue();
//
//        User expectedUser = new User(UserRole.ADMIN,
//                "null", "null", "null@null.null", "null123456");
//        expectedUser.setId(1L);
//
//        assertThat(getAllUsersResponse.getUsers().get(0)).isEqualTo(expectedUser);
//    }
//
//    private RegisterUserService registerUserService() {
//        return context.getBean(RegisterUserService.class);
//    }
//
//    private AuthorizeUserService authorizeUserService() {
//        return context.getBean(AuthorizeUserService.class);
//    }
//
//    private GetAllUsersService getAllUsersService() {
//        return context.getBean(GetAllUsersService.class);
//    }
//
//    private DatabaseCleaner databaseCleaner() {
//        return  context.getBean(DatabaseCleaner.class);
//    }
//}
