package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.config.HumanResourcesSystemConfiguration;
import lv.javaguru.java2.hrsystem.core.requests.*;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.*;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AcceptanceTestEmployeeDeletion {

    private ApplicationContext appContext;

    @Before
    public void setup(){
        appContext = new AnnotationConfigApplicationContext(HumanResourcesSystemConfiguration.class);
    }


    public AddEmployeeService getAddEmployeeService() {
        return appContext.getBean(AddEmployeeService.class);
    }

    public DeleteEmployeeService getDeleteEmployeeService() {
        return appContext.getBean(DeleteEmployeeService.class);
    }

    public GetAllEmployeesService getAllEmployeesService() {
        return appContext.getBean(GetAllEmployeesService.class);
    }

    @Test
    public void shouldDeleteEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("Tom", "Smith", 25);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 44);

        getAddEmployeeService().execute(addEmployeeRequest);
        getAddEmployeeService().execute(addEmployeeRequest1);

        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(1L);
        DeleteEmployeeResponse deleteEmployeeResponse = getDeleteEmployeeService().execute(deleteEmployeeRequest);

        GetAllEmployeesResponse getAllResponse = getAllEmployeesService().execute(new GetAllEmployeesRequest());

        assertThat(getAllResponse.getEmployees().size() == 1).isTrue();
        assertThat(getAllResponse.getEmployees()).isEqualTo(List.of(
                new Employee(2L, "John", "Smith", 44)));
    }

    @Test
    public void shouldNotDeleteNotFoundEmployee() {
        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest("Tom", "Smith", 25);
        AddEmployeeRequest addEmployeeRequest1 = new AddEmployeeRequest("John", "Smith", 44);

        getAddEmployeeService().execute(addEmployeeRequest);
        getAddEmployeeService().execute(addEmployeeRequest1);

        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(3L);
        DeleteEmployeeResponse deleteEmployeeResponse = getDeleteEmployeeService().execute(deleteEmployeeRequest);

        GetAllEmployeesResponse getAllResponse = getAllEmployeesService().execute(new GetAllEmployeesRequest());
        assertThat(getAllResponse.getEmployees().size() == 2).isTrue();
        assertThat(getAllResponse.getEmployees()).isEqualTo(List.of(
                new Employee(1L, "Tom", "Smith", 25),
                new Employee(2L, "John", "Smith", 44)));
    }
}