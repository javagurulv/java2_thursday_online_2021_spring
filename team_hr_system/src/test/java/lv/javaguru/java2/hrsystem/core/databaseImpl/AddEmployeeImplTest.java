package lv.javaguru.java2.hrsystem.core.databaseImpl;

import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddEmployeeImplTest {

   @Test
    public void addEmployeeServiceTest() {

        DatabaseImpl database = new DatabaseImpl();

        List<Employee> actual = new ArrayList<>();

        Employee objectOne = new Employee("A1", "F1");
        Employee objectTwo = new Employee("A2", "F2");

        database.saveEmployee(objectOne);
        database.saveEmployee(objectTwo);

        actual.add(database.getAllEmployees().get(0));
        actual.add(database.getAllEmployees().get(1));

        List<Employee> expected = new ArrayList<>();

        expected.add(objectOne);
        expected.add(objectTwo);

        assertEquals(expected, actual);

    }
}
