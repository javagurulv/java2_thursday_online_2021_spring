package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.bean.Employee;
import java.util.List;

public class GetEmployeesByTitleResponse {
    private List<Employee> employees;

    public GetEmployeesByTitleResponse(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}