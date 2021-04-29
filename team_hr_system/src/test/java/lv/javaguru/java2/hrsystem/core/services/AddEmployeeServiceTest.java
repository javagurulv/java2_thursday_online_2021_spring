package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.matchers.EmployeeMatcher;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeServiceTest {
    @Mock
    private Database database;

    @Mock
    private AddEmployeeRequestValidator validator;

    @InjectMocks
    private AddEmployeeService service;

    @Test
    public void shouldReturnErrorsInCaseOfAllInvalidEntries() {
        AddEmployeeRequest request = new AddEmployeeRequest("", "", 0);
        List<CoreError> expected = List.of(
                new CoreError("name", "Must not be empty!"),
                new CoreError("last name", "Must not be empty!"),
                new CoreError("age", "Must be > 0!"));
        Mockito.when(validator.validate(request)).thenReturn(expected);
        AddEmployeeResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 3).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {
        AddEmployeeRequest request = new AddEmployeeRequest("Tom", "Smith", 28);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        AddEmployeeResponse response = service.execute(request);
        assertThat(response.hasErrors()).isFalse();
        Mockito.verify(database).saveEmployee(argThat(
                new EmployeeMatcher("Tom", "Smith", 28)));
    }

    @Test
    public void shouldReturnErrorsInCaseOneInvalid() {
        AddEmployeeRequest request = new AddEmployeeRequest("Tom", "", 25);
        List<CoreError> expected = List.of(
                new CoreError("last name", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(expected);
        AddEmployeeResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldReturnErrorsInCaseOneNull() {
        AddEmployeeRequest request = new AddEmployeeRequest(null, "Last", 25);
        List<CoreError> expected = List.of(
                new CoreError("name", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(expected);
        AddEmployeeResponse response = service.execute(request);
        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);
        Mockito.verifyNoInteractions(database);
    }
}