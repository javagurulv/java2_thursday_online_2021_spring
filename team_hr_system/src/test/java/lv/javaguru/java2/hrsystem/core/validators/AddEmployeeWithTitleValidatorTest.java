package lv.javaguru.java2.hrsystem.core.validators;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeWithTitleValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.TitleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeWithTitleValidatorTest {

    @InjectMocks
    private AddEmployeeWithTitleValidator validator = new AddEmployeeWithTitleValidator();

    @Mock
    private TitleValidator titleValidator;

    @Test
    public void testValidTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "QA_ENGINEER");
        Mockito.when(titleValidator.titleExists(new EmployeeTitle(request.getName()))).thenReturn(true);
        assertThat(validator.validate(request).isEmpty()).isTrue();
    }

    @Test
    public void testEmptyTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "");
        assertThat(validator.validate(request))
                .contains(new CoreError("employee title", "Must not be empty!"));
    }
}