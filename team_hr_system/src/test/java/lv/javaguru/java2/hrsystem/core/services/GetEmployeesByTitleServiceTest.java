package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.requests.GetEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetEmployeesByTitleResponse;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetEmployeesByTitleServiceTest {
    private Database database;
    private GetEmployeesByTitleService service;

  /*  @Test
    public void getEmployeesByTitleService_Positive() {
        database = new DatabaseImpl();
        service = new GetEmployeesByTitleService(database);
        database.saveEmployee(new Employee("aaa", "bbb", 35, EmployeeTitle.BA));
        List<Employee> exp = new ArrayList<>() {{
            add(new Employee("aaa", "bbb", 35, EmployeeTitle.BA));
        }};
        GetEmployeesByTitleRequest request = new GetEmployeesByTitleRequest(EmployeeTitle.BA);
        GetEmployeesByTitleResponse response = service.execute(request);
        Assertions.assertThat(response.getEmployees()).isEqualTo(exp);
    }*/
}