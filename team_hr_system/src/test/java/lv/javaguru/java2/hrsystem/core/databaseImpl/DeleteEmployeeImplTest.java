package lv.javaguru.java2.hrsystem.core.databaseImpl;

import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteEmployeeImplTest {

    @Test
    public void deleteEmployeeServiceTest() {

        DatabaseImpl database = new DatabaseImpl();

        Employee objectOne = new Employee("A1", "F1");
        Employee objectTwo = new Employee("A2", "F2");

        database.saveEmployee(objectOne);
        database.saveEmployee(objectTwo);

        database.deleteEmployee(1L);

        List<Employee> actual = new ArrayList<>(database.getAllEmployees());
        List<Employee> expected = new ArrayList<>();

        expected.add(objectTwo);

        assertEquals(expected.get(0), actual.get(0));

    }
}
