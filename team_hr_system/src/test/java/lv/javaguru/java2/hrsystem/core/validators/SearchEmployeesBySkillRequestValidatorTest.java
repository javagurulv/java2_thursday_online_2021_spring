package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.domain.Skill;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesBySkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.SearchEmployeesBySkillRequestValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.skill.SkillValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class SearchEmployeesBySkillRequestValidatorTest {

    @InjectMocks
    private SearchEmployeesBySkillRequestValidator validator;

    @Mock
    private SkillValidator skillValidator;

    @Test
    public void testNullSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest(null);
        List<CoreError> exp = new ArrayList<>() {{
            add(new CoreError("skill name", "Must not be empty!"));
            add(new CoreError("this skill", "is not added yet!"));

        }};
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testBlankSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("");
        List<CoreError> exp = new ArrayList<>() {{
            add(new CoreError("skill name", "Must not be empty!"));
            add(new CoreError("this skill", "is not added yet!"));

        }};
        assertThat(validator.validate(request)).isEqualTo(exp);
    }

    @Test
    public void testValidSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("DevOps");
        Mockito.when(skillValidator.skillExists(new Skill(request.getSkillName()))).thenReturn(true);
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testInValidSkillName() {
        SearchEmployeesBySkillRequest request = new SearchEmployeesBySkillRequest("DevOps");
        Mockito.when(skillValidator.skillExists(new Skill(request.getSkillName()))).thenReturn(false);
        assertThat(validator.validate(request)).isEqualTo(List.of(new CoreError("this skill", "is not added yet!")));
    }
}