package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DeleteEmployeeServiceTest {
    private Database database;
    private DeleteEmployeeService deleteEmployeeService;

    @Test
    public void testDeleteEmployeeServicePositive() {
        database = new DatabaseImpl();
        deleteEmployeeService = new DeleteEmployeeService(database);
        database.saveEmployee(new Employee("aaa", "bbb"));
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(1L);
        DeleteEmployeeResponse deleteEmployeeResponse = deleteEmployeeService.execute(deleteEmployeeRequest);
        assertThat(deleteEmployeeResponse.hasErrors()).isFalse();
        assertThat(deleteEmployeeResponse.isRemoved()).isTrue();
    }

    @Test
    public void testDeleteEmployeeServiceNegative() {
        database = new DatabaseImpl();
        deleteEmployeeService = new DeleteEmployeeService(database);
        database.saveEmployee(new Employee("aaa", "bbb"));
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(2L);
        DeleteEmployeeResponse deleteEmployeeResponse = deleteEmployeeService.execute(deleteEmployeeRequest);
        assertThat(deleteEmployeeResponse.hasErrors()).isFalse();
        assertThat(deleteEmployeeResponse.isRemoved()).isFalse();
    }

    @Test
    public void testDeleteEmployeeServiceWithErrors() {
        database = new DatabaseImpl();
        deleteEmployeeService = new DeleteEmployeeService(database);
        database.saveEmployee(new Employee("aaa", "bbb"));
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(null);
        DeleteEmployeeResponse deleteEmployeeResponse = deleteEmployeeService.execute(deleteEmployeeRequest);
        assertThat(deleteEmployeeResponse.hasErrors()).isTrue();
        assertThat(deleteEmployeeResponse.isRemoved()).isFalse();
    }
}