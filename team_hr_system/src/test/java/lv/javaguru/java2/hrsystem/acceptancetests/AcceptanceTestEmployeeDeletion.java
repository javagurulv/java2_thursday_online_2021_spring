package lv.javaguru.java2.hrsystem.acceptancetests;

import lv.javaguru.java2.hrsystem.dependency_injection.ApplicationContext;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.DeleteEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeesService;
import lv.javaguru.java2.hrsystem.dependency_injection.DIApplicationContextBuilder;
import lv.javaguru.java2.hrsystem.domain.Employee;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AcceptanceTestEmployeeDeletion {
    private static ApplicationContext context = new DIApplicationContextBuilder()
            .build("lv.javaguru.java2.hrsystem");

    public AddEmployeeService getAddEmployeeService() {
        return context.getBean(AddEmployeeService.class);
    }

    public DeleteEmployeeService getDeleteEmployeeService() {
        return context.getBean(DeleteEmployeeService.class);
    }

    public GetAllEmployeesService getAllEmployeesService() {
        return context.getBean(GetAllEmployeesService.class);
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
}