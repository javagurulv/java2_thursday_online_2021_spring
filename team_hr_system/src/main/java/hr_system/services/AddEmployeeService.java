package hr_system.services;

import hr_system.bean.Employee;
import hr_system.database.Database;

public class AddEmployeeService {

    private Database database;

    public AddEmployeeService(Database database) {

        this.database = database;

    }

    public void execute(String firstNameEmployee, String secondNameEmployee, int ageEmployee) {
        Employee employee = new Employee(firstNameEmployee, secondNameEmployee, ageEmployee);
        database.saveEmployee(employee);
    }
}
