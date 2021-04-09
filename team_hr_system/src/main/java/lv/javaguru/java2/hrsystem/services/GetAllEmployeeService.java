package lv.javaguru.java2.hrsystem.services;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.database.Database;

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
