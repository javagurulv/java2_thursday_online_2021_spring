package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.title.AddEmployeeTitleService;
import lv.javaguru.java2.hrsystem.core.services.validators.title.AddEmployeeTitleRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeTitleServiceTest {

    @Mock
    private AddEmployeeTitleRequestValidator validator;

    @Mock
    //private EmployeeTitleRepository repository;
    private ORMEmployeeTitleRepository ormEmployeeTitleRepository;

    @InjectMocks
    private AddEmployeeTitleService service;

    @Test
    public void testInvalidTitle() {
        AddEmployeeTitleRequest request = new AddEmployeeTitleRequest("", "Sample description");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of(
                new CoreError("title", " Must not be empty")));
        Mockito.verifyNoInteractions(ormEmployeeTitleRepository);
    }

    @Test
    public void testInvalidDescription() {
        AddEmployeeTitleRequest request = new AddEmployeeTitleRequest("QA", "");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of(
                new CoreError("description", " Must not be empty")));
        Mockito.verifyNoInteractions(ormEmployeeTitleRepository);
    }

    @Test
    public void testValidInsert() {
        AddEmployeeTitleRequest request = new AddEmployeeTitleRequest("qa", "Sample description");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(ormEmployeeTitleRepository.saveTitle(new EmployeeTitle(request.getTitle(), request.getDescription()))).thenReturn(
                true);
        AddEmployeeTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.isTitleAdded()).isTrue();
    }

    @Test
    public void testAlreadyAdded() {
        AddEmployeeTitleRequest request = new AddEmployeeTitleRequest("qa", "Sample description");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(ormEmployeeTitleRepository.saveTitle(new EmployeeTitle(request.getTitle(), request.getDescription()))).thenReturn(
                false);
        AddEmployeeTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.isTitleAdded()).isFalse();
    }
}