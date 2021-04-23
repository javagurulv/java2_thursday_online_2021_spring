package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddSkillRequestValidator;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AddSkillRequestValidatorTest {
    private final AddSkillRequestValidator validator = new AddSkillRequestValidator();

    @Test
    public void testNullEmployeeID() {
        AddSkillRequest request = new AddSkillRequest(null, "Java");
        List<CoreError> exp = List.of(new CoreError("employee id", " Must not be empty!"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testEmptySkillName() {
        AddSkillRequest request = new AddSkillRequest(1L, " ");
        List<CoreError> exp = List.of(new CoreError("employee skill", " Must not be empty!"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testNullSkillName() {
        AddSkillRequest request = new AddSkillRequest(1L, null);
        List<CoreError> exp = List.of(new CoreError("employee skill", " Must not be empty!"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testNullSkillNameNullId() {
        AddSkillRequest request = new AddSkillRequest(null, null);
        List<CoreError> exp = List.of(
                new CoreError("employee id", " Must not be empty!"),
                new CoreError("employee skill", " Must not be empty!"));
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testNoErrors() {
        AddSkillRequest request = new AddSkillRequest(1L, "Java");
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }
}