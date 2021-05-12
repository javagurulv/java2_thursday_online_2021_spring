package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllEmployeesService {

   @Autowired private Database database;

    public GetAllEmployeesResponse execute(GetAllEmployeesRequest request) {
        List<Employee> employees = database.getAllEmployees();
        return new GetAllEmployeesResponse(employees);
    }
}
