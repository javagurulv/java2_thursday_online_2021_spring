package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.skill.AddSkillRequestValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.EmployeeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddSkillRequestValidatorTest {

    @Mock
    private EmployeeValidator employeeValidator;

    @InjectMocks
    private final AddSkillRequestValidator validator = new AddSkillRequestValidator();

    @Test
    public void testNullEmployeeID() {
        AddSkillRequest request = new AddSkillRequest(null, "Java");
        List<CoreError> exp = List.of(new CoreError("employee id", " Must not be empty!"),
                new CoreError("employee id", " does not exist"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testEmptySkillNameExistingEmployee() {
        AddSkillRequest request = new AddSkillRequest(1L, " ");
        Mockito.when(employeeValidator.employeeExists(request.getEmployeeId())).thenReturn(true);
        List<CoreError> exp = List.of(new CoreError("employee skill", " Must not be empty!"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testNullSkillNameExistingEmployee() {
        AddSkillRequest request = new AddSkillRequest(1L, null);
        Mockito.when(employeeValidator.employeeExists(request.getEmployeeId())).thenReturn(true);
        List<CoreError> exp = List.of(new CoreError("employee skill", " Must not be empty!"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testNullSkillNameNullId() {
        AddSkillRequest request = new AddSkillRequest(null, null);
        List<CoreError> exp = List.of(
                new CoreError("employee id", " Must not be empty!"),
                new CoreError("employee skill", " Must not be empty!"),
                new CoreError("employee id", " does not exist"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testNoErrors() {
        AddSkillRequest request = new AddSkillRequest(1L, "Java");
        Mockito.when(employeeValidator.employeeExists(request.getEmployeeId())).thenReturn(true);
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }
}