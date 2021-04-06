package hr_system.services;

import hr_system.bean.Employee;
import hr_system.database.Database;

import java.util.List;

public class GetAllEmployeeService {

    private Database database;

    public GetAllEmployeeService(Database database) {

        this.database = database;

    }

    public List<Employee> execute () {

        return database.getAllEmployees();

    }
}
