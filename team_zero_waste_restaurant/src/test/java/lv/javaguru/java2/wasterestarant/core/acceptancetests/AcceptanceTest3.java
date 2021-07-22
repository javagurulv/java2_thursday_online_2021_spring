package lv.javaguru.java2.wasterestarant.core.acceptancetests;

import lv.javaguru.java2.wasterestarant.config.SpringCoreConfiguration;
import lv.javaguru.java2.wasterestarant.core.DatabaseCleaner;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangePasswordRequest;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangePasswordResponse;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangeUserRoleResponse;
import lv.javaguru.java2.wasterestarant.core.responses.user.LoginResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangePasswordService;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangeUserRoleService;
import lv.javaguru.java2.wasterestarant.core.services.user.LoginService;
import lv.javaguru.java2.wasterestarant.core.services.user.RegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AcceptanceTest3 {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
        getDatabaseCleaner().clean();
    }

    @Test
    public void userRegistrationLoginPasswordChange(){
        RegistrationRequest registrationRequest = new RegistrationRequest("Alina", "Saule", "alina@alina.lv", "alinaalina");
        registrationService().execute(registrationRequest);

        LoginRequest loginRequest1 = new LoginRequest("alina@alina.lv", "alinaalina");
        LoginResponse loginResponse1 = loginService().execute(loginRequest1);
        assertEquals(loginResponse1.getUser().getEmail(), "alina@alina.lv");
        assertEquals(loginResponse1.getUser().getPassword(), "alinaalina");

        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest("saulite", "alina@alina.lv");
        ChangePasswordResponse changePasswordResponse = changePasswordService().execute(changePasswordRequest);
        assertTrue(changePasswordResponse.isPasswordChanged());
    }


    @Test
    public void userLoginRoleChange(){
        RegistrationRequest registrationRequest = new RegistrationRequest("Alina", "Saule", "alina@alina.lv", "alinaalina");
        registrationService().execute(registrationRequest);

        LoginRequest loginRequest = new LoginRequest("alina@alina.lv", "alinaalina");
        LoginResponse loginResponse = loginService().execute(loginRequest);
        assertEquals(loginResponse.getUser().getEmail(), "alina@alina.lv");
        assertEquals(loginResponse.getUser().getPassword(), "alinaalina");

        ChangeUserRoleRequest changeUserRoleRequest = new ChangeUserRoleRequest(UserRole.ADMIN, "alina@alina.lv");
        ChangeUserRoleResponse changeUserRoleResponse = changeUserRoleService().execute(changeUserRoleRequest);
        assertTrue(changeUserRoleResponse.isUserRoleChanged());
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }

    private RegistrationService registrationService() {
        return applicationContext.getBean(RegistrationService.class);
    }

    private ChangePasswordService changePasswordService() {
        return applicationContext.getBean(ChangePasswordService.class);
    }

    private ChangeUserRoleService changeUserRoleService() {
        return applicationContext.getBean(ChangeUserRoleService.class);
    }

    private LoginService loginService() {
        return applicationContext.getBean(LoginService.class);
    }
}
