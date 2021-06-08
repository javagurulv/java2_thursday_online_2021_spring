package lv.javaguru.java2.hrsystem.core.databaseImpl;

import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetEmployeesByTitleImplTest {

    @Test
    public void getEmployeesByTitleTest() {

        DatabaseImpl database = new DatabaseImpl();

        Employee objectOne = new Employee("A1", "F1", 21, new EmployeeTitle("Hr_MANAGER"));
        Employee objectTwo = new Employee("A2", "F1", 32, new EmployeeTitle("DEVELOPER"));

        database.saveEmployee(objectOne);
        database.saveEmployee(objectTwo);

        List<Employee> actual = new ArrayList<>();
        actual.add(objectTwo);

        List<Employee> expected = new ArrayList<>(database.getEmployeesByTitle(new EmployeeTitle("DEVELOPER")));

        assertEquals(expected, actual);

    }
}
