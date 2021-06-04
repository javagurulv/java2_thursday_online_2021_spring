package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeRepository;
import lv.javaguru.java2.hrsystem.core.database.EmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeWithTitleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeWithTitleServiceTest {
    @InjectMocks
    private AddEmployeeWithTitleService service;

    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeTitleRepository titleRepository;

    @Mock
    private AddEmployeeWithTitleValidator validator;

    @Test
    public void addWithValidTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 22, "DEVELOPER");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(titleRepository.getAllUniqueTitles()).thenReturn(List.of(new EmployeeTitle("DEVELOPER")));
        Mockito.when(repository.saveEmployeeWithTitleAndReturnID(new Employee(
                request.getName(), request.getLastName(), request.getAge(), new EmployeeTitle(request.getTitle()))))
                .thenReturn(BigInteger.valueOf(1L));
        AddEmployeeWithTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getEmployee()).isEqualTo(
                new Employee(1L,"Aaa", "Bbb", 22, new EmployeeTitle("DEVELOPER")));
    }

    @Test
    public void addWithEmptyTitle() {
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest("Aaa", "Bbb", 25, "");
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of(
                new CoreError("employee title", "Must not be empty!")));
        AddEmployeeWithTitleResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors()).isEqualTo(List.of(
                new CoreError("employee title", "Must not be empty!")));
        Mockito.verifyNoInteractions(repository);
    }
}