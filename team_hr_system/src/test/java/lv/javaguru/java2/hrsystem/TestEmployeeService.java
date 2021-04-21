package lv.javaguru.java2.hrsystem;

import lv.javaguru.java2.hrsystem.domain.Admin;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEmployeeService {

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

    @Test
    public void getAllEmployeeServiceTest() {

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

    @Test
    public void getEmployeesByTitleTest() {

        DatabaseImpl database = new DatabaseImpl();

        Employee objectOne = new Employee("A1", "F1", 21, EmployeeTitle.HR_MANAGER);
        Employee objectTwo = new Employee("A2", "F1", 32, EmployeeTitle.DEVELOPER);

        database.saveEmployee(objectOne);
        database.saveEmployee(objectTwo);

        List<Employee> actual = new ArrayList<>();
        actual.add(objectTwo);

        List<Employee> expected = new ArrayList<>(database.getEmployeesByTitle(EmployeeTitle.DEVELOPER));

        assertEquals(expected, actual);

    }

    @Test
    public void loginAdmTest() {

        DatabaseImpl database = new DatabaseImpl();

        Admin objectOne = new Admin("Alex", "Med", "alexmed@gmail.com", "qwert123");
        Admin objectTwo = new Admin("Max", "Lem", "maxlim@", "qwert123456");

        database.registrationAdm(objectOne);
        database.registrationAdm(objectTwo);

        List<Boolean> actual = new ArrayList<>();
        actual.add(true);
        actual.add(true);

        List<Boolean> expected = new ArrayList<>();

        expected.add(database.loginAdm("alexmed@gmail.com", "qwert123"));
        expected.add(database.loginAdm("maxlim@", "qwert123456"));

        assertEquals(expected, actual);

    }
}
