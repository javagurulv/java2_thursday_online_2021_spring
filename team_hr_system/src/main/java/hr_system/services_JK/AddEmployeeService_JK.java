package hr_system.services_JK;

import hr_system.bean.Employee;
import hr_system.database.Database;

public class AddEmployeeService_JK {
    private final Database database;

    public AddEmployeeService_JK(Database database) {
        this.database = database;
    }

    public void add(String firstName, String lastName, int age) {
        database.saveEmployee(new Employee(firstName, lastName, age));
    }
}