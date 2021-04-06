package hr_system.services_JK;

import hr_system.bean.Employee;
import hr_system.database.Database;

import java.util.List;

public class GetAllEmployees_JK {
    private final Database database;

    public GetAllEmployees_JK(Database database) {
        this.database = database;
    }

    public List<Employee> getAll() {
        return database.getAllEmployees();
    }
}