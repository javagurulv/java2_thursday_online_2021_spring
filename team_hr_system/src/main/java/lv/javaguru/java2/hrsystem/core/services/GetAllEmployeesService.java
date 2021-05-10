package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetAllEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllEmployeesResponse;

import java.util.List;

@DIComponent
public class GetAllEmployeesService {

   @DIDependency private Database database;

    public GetAllEmployeesResponse execute(GetAllEmployeesRequest request) {
        List<Employee> employees = database.getAllEmployees();
        return new GetAllEmployeesResponse(employees);
    }
}
