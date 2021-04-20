package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AddEmployeeWithTitleValidatorTest {
    private AddEmployeeWithTitleValidator validator = new AddEmployeeWithTitleValidator();

    @Test
    public void testValidTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "QA_ENGINEER");
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testInValidTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "QA");
        assertThat(validator.validate(request))
                .contains(new CoreError("invalid title - QA", " Must be selected from the pre-defined set!"));
    }

    @Test
    public void testEmptyTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "");
        assertThat(validator.validate(request))
                .contains(new CoreError("employee title", "Must not be empty!"));
    }
}