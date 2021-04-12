package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;

import java.util.List;

public class GetAllEmployeesService {

    private Database database;

    public GetAllEmployeesService(Database database) {
        this.database = database;
    }

    public GetAllEmployeesResponse execute(GetAllEmployeesRequest request) {
        List<Employee> employees = database.getAllEmployees();
        return new GetAllEmployeesResponse(employees);
    }
}
