/*package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.SearchEmployeesBySkillRequestValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SearchEmployeesBySkillRequestValidatorTest {
    private SearchEmployeesBySkillRequestValidator validator = new SearchEmployeesBySkillRequestValidator();

    @Test
    public void testNullSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest(null);
        List<CoreError> exp = new ArrayList<>() {{
            add(new CoreError("skill name", "Must not be empty!"));
        }};
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testBlankSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("");
        List<CoreError> exp = new ArrayList<>() {{
            add(new CoreError("skill name", "Must not be empty!"));
        }};
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testValidSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("DevOps");
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }
}*/