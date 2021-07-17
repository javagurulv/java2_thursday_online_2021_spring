package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.AddEmployeeWithTitleValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.title.TitleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeWithTitleValidatorTest {

    @InjectMocks
    private AddEmployeeWithTitleValidator validator = new AddEmployeeWithTitleValidator();

    @Mock
    private TitleValidator titleValidator;

    @Test
    public void testValidTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "QA_ENGINEER");
        Mockito.when(titleValidator.titleExists(new EmployeeTitle(request.getTitle()))).thenReturn(true);
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testEmptyTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "");
        assertThat(validator.validate(request))
                .contains(new CoreError("employee title", "Must not be whitespace!"));
    }

    @Test
    public void testNonExistingTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "Manager");
        assertThat(validator.validate(request)).isEqualTo(List.of(
                new CoreError("this title", "is not added yet")));
    }
}