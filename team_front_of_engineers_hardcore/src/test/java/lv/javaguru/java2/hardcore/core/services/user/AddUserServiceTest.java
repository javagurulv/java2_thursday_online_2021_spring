package lv.javaguru.java2.hardcore.core.services.user;

import lv.javaguru.java2.hardcore.core.database.UserDatabase;
import lv.javaguru.java2.hardcore.core.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.core.response.user.AddUserResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddUserServiceTest {

    private UserDatabase userDatabase;
    private AddUserValidator addUserValidator;
    private AddUserService addUserService;

    @Before
    public void init() {
        userDatabase = new UserDatabaseMock();
        addUserValidator = new AddUserValidatorMock();
        addUserService = new AddUserService();
    }
    @Test
    public void addUserTest() {
        AddUserRequest request = new AddUserRequest(null, null);
        AddUserResponse response = addUserService.execute(request);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);

    }
}