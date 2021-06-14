package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.AddEmployeeRequestValidator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AddEmployeeValidatorTest {
    private AddEmployeeRequestValidator validator = new AddEmployeeRequestValidator();

    @Test
    public void testValidName() {
        AddEmployeeRequest request = new AddEmployeeRequest("AAA", "Bbb", 55);
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testNullName() {
        AddEmployeeRequest request = new AddEmployeeRequest(null, "Bbb", 55);
        assertThat(validator.validate(request)).contains(new CoreError("name", "Must not be empty!"));
    }

    @Test
    public void testEmptyName() {
        AddEmployeeRequest request = new AddEmployeeRequest("", "Bbb", 55);
        assertThat(validator.validate(request)).contains(new CoreError("name", "Must not be empty!"));
    }
}