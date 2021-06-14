package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.Ordering;
import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesService;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.SearchEmployeesRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SearchEmployeesServiceTest {

    @Mock
  //  private EmployeeRepository employeeRepository;
    private ORMEmployeeRepository ormEmployeeRepository;
    @Mock
    private SearchEmployeesRequestValidator validator;
    @InjectMocks
    private SearchEmployeesService service;


    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchEmployeesRequest request = new SearchEmployeesRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("name", "Must not be empty!"));
        errors.add(new CoreError("title", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchEmployeesResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(ormEmployeeRepository);
    }

    @Test
    public void shouldSearchByName() {
        SearchEmployeesRequest request = new SearchEmployeesRequest(null, "Name");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Name", "LastName"));
        Mockito.when(ormEmployeeRepository.getEmployeesByName("Name")).thenReturn(employees);

        SearchEmployeesResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getEmployees().size(), 1);
        assertEquals(response.getEmployees().get(0).getName(), "Name");
        assertEquals(response.getEmployees().get(0).getLastName(), "LastName");
    }

    @Test
    public void shouldSearchByTitle() {
        SearchEmployeesRequest request = new SearchEmployeesRequest("BA", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Name", "LastName", 34, new EmployeeTitle("BA")));
        Mockito.when(ormEmployeeRepository.getEmployeesByTitle(new EmployeeTitle("BA"))).thenReturn(employees);

        SearchEmployeesResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getEmployees().size(), 1);
        assertEquals(response.getEmployees().get(0).getName(), "Name");
        assertEquals(response.getEmployees().get(0).getLastName(), "LastName");
        assertEquals(response.getEmployees().get(0).getAge(), 34);
        assertEquals(response.getEmployees().get(0).getTitle(), new EmployeeTitle("BA"));
    }

    @Test
    public void shouldSearchByNameAndTitle() {
        SearchEmployeesRequest request = new SearchEmployeesRequest("MANAGER", "Name");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Name", "LastName", 42, new EmployeeTitle("MANAGER")));
        Mockito.when(ormEmployeeRepository.getEmployeesByTitleAndName(new EmployeeTitle("MANAGER"), "Name")).thenReturn(employees);

        SearchEmployeesResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getEmployees().size(), 1);
        assertEquals(response.getEmployees().get(0).getName(), "Name");
        assertEquals(response.getEmployees().get(0).getLastName(), "LastName");
        assertEquals(response.getEmployees().get(0).getAge(), 42);
        assertEquals(response.getEmployees().get(0).getTitle(), new EmployeeTitle("MANAGER"));
    }

    @Test
    public void shouldSearchByNameWithOrderingDescending() {
        Ordering ordering = new Ordering("title", "DESCENDING");
        SearchEmployeesRequest request = new SearchEmployeesRequest(null, "Name", ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Name", "LastName", 34, new EmployeeTitle("BA")));
        employees.add(new Employee("Name", "LastName", 42, new EmployeeTitle("MANAGER")));
        Mockito.when(ormEmployeeRepository.getEmployeesByName("Name")).thenReturn(employees);

        SearchEmployeesResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getEmployees().size(), 2);
        assertEquals(response.getEmployees().get(0).getTitle(), new EmployeeTitle("MANAGER"));
        assertEquals(response.getEmployees().get(1).getTitle(), new EmployeeTitle("BA"));
    }

    @Test
    public void shouldSearchByTitleWithOrderingAscending() {
        Ordering ordering = new Ordering("name", "ASCENDING");
        SearchEmployeesRequest request = new SearchEmployeesRequest("QA_ENGINEER", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("NameB", "LastName", 34, new EmployeeTitle("QA_ENGINEER")));
        employees.add(new Employee("NameA", "LastName", 42, new EmployeeTitle("QA_ENGINEER")));
        Mockito.when(ormEmployeeRepository.getEmployeesByTitle(new EmployeeTitle("QA_ENGINEER"))).thenReturn(employees);

        SearchEmployeesResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getEmployees().size(), 2);
        assertEquals(response.getEmployees().get(0).getName(), "NameA");
        assertEquals(response.getEmployees().get(1).getName(), "NameB");
    }

    @Test
    public void shouldSearchByTitleWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchEmployeesRequest request = new SearchEmployeesRequest("SALES_MANAGER", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("NameA", "LastName", 42, new EmployeeTitle("SALES_MANAGER")));
        employees.add(new Employee("NameB", "LastName", 34, new EmployeeTitle("SALES_MANAGER")));
        Mockito.when(ormEmployeeRepository.getEmployeesByTitle(new EmployeeTitle("SALES_MANAGER"))).thenReturn(employees);

        SearchEmployeesResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getEmployees().size(), 1);
        assertEquals(response.getEmployees().get(0).getName(), "NameB");
        assertEquals(response.getEmployees().get(0).getAge(), 34);
        assertEquals(response.getEmployees().get(0).getTitle(), new EmployeeTitle("SALES_MANAGER"));
    }
}