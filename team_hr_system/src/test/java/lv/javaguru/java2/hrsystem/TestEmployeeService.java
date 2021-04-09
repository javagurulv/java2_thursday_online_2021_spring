package lv.javaguru.java2.hrsystem;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.database.DatabaseImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestEmployeeService {

    @Test
    public void AddEmployeeServiceTest() {

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

    @Test
    public void DeleteEmployeeServiceTest() {

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

    @Test
    public void GetAllEmployeeServiceTest() {

        DatabaseImpl database = new DatabaseImpl();

        Employee objectOne = new Employee("A1", "F1");
        Employee objectTwo = new Employee("A2", "F2");

        database.saveEmployee(objectOne);
        database.saveEmployee(objectTwo);

        List<Employee> actual = new ArrayList<>(database.getAllEmployees());
        List<Employee> expected = new ArrayList<>();

        expected.add(objectOne);
        expected.add(objectTwo);

        assertEquals(expected, actual);
    }

}
