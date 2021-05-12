package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.Employee;

import java.util.List;

public class GetAllEmployeesResponse extends CoreResponse{
    private List<Employee> employees;

    public GetAllEmployeesResponse(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean hasEmployees() {
        return !employees.isEmpty();
    }
}