package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeWithTitleService;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.AddEmployeeWithTitleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeWithTitleServiceTest {
    @InjectMocks
    private AddEmployeeWithTitleService service;

    @Mock
    //private EmployeeRepository repository;
    private ORMEmployeeRepository ormEmployeeRepository;

    @Mock
    //private EmployeeTitleRepository titleRepository;
    private ORMEmployeeTitleRepository ormEmployeeTitleRepository;

    @Mock
    private AddEmployeeWithTitleValidator validator;

    @Test
    public void addWithValidTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "DEVELOPER");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());
        Mockito.lenient().when(ormEmployeeTitleRepository.getAllUniqueTitles()).thenReturn(List.of(new EmployeeTitle("DEVELOPER")));
        Mockito.when(ormEmployeeRepository.saveEmployee(new Employee(
                request.getName(), request.getLastName(), request.getAge(), new EmployeeTitle(request.getTitle()))))
                .thenReturn(1L);
        AddEmployeeWithTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getEmployee()).isEqualTo(
                new Employee(1L, "Aaa", "Bbb", 22, new EmployeeTitle("DEVELOPER")));
    }

    @Test
    public void addWithEmptyTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 25, "");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of(
                new CoreError("employee title", "Must not be whitespace!")));
        AddEmployeeWithTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors()).isEqualTo(List.of(
                new CoreError("employee title", "Must not be whitespace!")));
        Mockito.verifyNoInteractions(ormEmployeeRepository);
    }

    @Test
    public void addWithNonExistingTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 25, "Dev");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of(
                new CoreError("this title", "is not added yet")
        ));
        AddEmployeeWithTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors()).isEqualTo(List.of(new CoreError("this title", "is not added yet")));
        Mockito.verifyNoInteractions(ormEmployeeRepository);
    }
}