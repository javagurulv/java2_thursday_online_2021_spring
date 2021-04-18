package lv.javaguru.java2.hrsystem.core.requests;

import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

public class GetEmployeesByTitleRequest{
    private final String employeeTitle;

    public GetEmployeesByTitleRequest(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }
}