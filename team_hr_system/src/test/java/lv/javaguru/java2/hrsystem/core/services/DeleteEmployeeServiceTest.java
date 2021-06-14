package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.DeleteEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.DeleteEmployeeRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DeleteEmployeeServiceTest {

    @Mock
    private DeleteEmployeeRequestValidator validator;

    @Mock
    //private EmployeeRepository employeeRepository;
    private ORMEmployeeRepository ormEmployeeRepository;

    @InjectMocks
    private DeleteEmployeeService service;

    @Test
    public void testResponseWithInvalidRequest() {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest(null);
        List<CoreError> errors = new ArrayList<>() {{
            add(new CoreError("employee id", " Must not be empty!"));
        }};
        Mockito.lenient().when(validator.validate(request)).thenReturn(errors);
        DeleteEmployeeResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors()).isEqualTo(errors);
        Mockito.verifyNoInteractions(ormEmployeeRepository);
    }

    @Test
    public void testResponseWithValidRequest() {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest(1L);
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(ormEmployeeRepository.deleteEmployee(1L)).thenReturn(true);
        DeleteEmployeeResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        assertThat(response.isRemoved()).isTrue();
    }

    @Test
    public void testResponseWithValidRequestNoIdInDB() {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest(1L);
        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(ormEmployeeRepository.deleteEmployee(1L)).thenReturn(false);
        DeleteEmployeeResponse response = service.execute(request);
        assertThat(!response.hasErrors()).isTrue();
        assertThat(response.isRemoved()).isFalse();
    }
}