package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;

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
