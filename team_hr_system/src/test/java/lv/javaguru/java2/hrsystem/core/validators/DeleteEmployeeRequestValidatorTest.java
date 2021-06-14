package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.DeleteEmployeeRequestValidator;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DeleteEmployeeRequestValidatorTest {
    private DeleteEmployeeRequestValidator validator = new DeleteEmployeeRequestValidator();

    @Test
    public void testNonEmptyId() {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest(1L);
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testEmptyId() {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest(null);
        assertThat(validator.validate(request))
                .isEqualTo(List.of(new CoreError("employee id", " Must not be empty!")));
    }
}