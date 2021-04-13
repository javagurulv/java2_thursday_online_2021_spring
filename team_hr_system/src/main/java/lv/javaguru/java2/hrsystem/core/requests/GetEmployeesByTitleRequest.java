package lv.javaguru.java2.hrsystem.core.requests;

import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

public class GetEmployeesByTitleRequest{
    private final EmployeeTitle employeeTitle;

    public GetEmployeesByTitleRequest(EmployeeTitle employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public EmployeeTitle getEmployeeTitle() {
        return employeeTitle;
    }
}