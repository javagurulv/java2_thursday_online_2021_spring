package lv.javaguru.java2.hrsystem.services_JK;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.database.Database;

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