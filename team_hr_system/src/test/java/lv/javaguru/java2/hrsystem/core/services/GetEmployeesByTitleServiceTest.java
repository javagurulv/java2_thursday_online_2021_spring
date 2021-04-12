package lv.javaguru.java2.hrsystem.core.services;


import lv.javaguru.java2.hrsystem.core.database.Database;
import org.junit.Test;



public class GetEmployeesByTitleServiceTest {
    private Database database;
    private GetEmployeesByTitleService service;

    @Test
    public void getEmployeesByTitleService_Positive() {
        //TBD
       /* database = new DatabaseImpl();
        service = new GetEmployeesByTitleService(database);
        database.saveEmployee(new Employee("aaa", "bbb", 35, EmployeeTitle.BA));
        List<Employee> exp = new ArrayList<>() {{
            add(new Employee("aaa", "bbb", 35, EmployeeTitle.BA));
        }};
        GetEmployeesByTitleRequest request = new GetEmployeesByTitleRequest(EmployeeTitle.BA);
        GetEmployeesByTitleResponse response = service.execute(request);
        Assertions.assertThat(response.getEmployees()).isEqualTo(exp);*/
    }
}