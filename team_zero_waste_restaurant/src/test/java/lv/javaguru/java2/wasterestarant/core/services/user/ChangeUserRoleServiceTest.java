package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangeUserRoleResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.validators.ChangeUserRoleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChangeUserRoleServiceTest {
    @Mock
    private UserRepository repository;
    @Mock
    private ChangeUserRoleValidator validator;
    @InjectMocks
    ChangeUserRoleService service;

    @Test
    public void shouldChangeUserRole()  {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(UserRole.ADMIN, "admin@admin.lv");
        ChangeUserRoleResponse response = service.execute(request);
        assertFalse(response.hasErrors());
    }

    @Test
    public void shouldNotChangeUserRole()  {
        ChangeUserRoleRequest request = new ChangeUserRoleRequest(UserRole.ADMIN, "");
        List<CoreError> errors = new ArrayList<>(List.of(new CoreError("E-mail", "Must not be empty")));
        when(validator.validate(request)).thenReturn(errors);
        ChangeUserRoleResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "E-mail");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }
}