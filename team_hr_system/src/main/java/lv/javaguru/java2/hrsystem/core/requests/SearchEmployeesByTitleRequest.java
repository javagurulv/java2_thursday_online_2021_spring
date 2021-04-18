package lv.javaguru.java2.hrsystem.core.requests;

public class SearchEmployeesByTitleRequest {
    private final String employeeTitle;

    public SearchEmployeesByTitleRequest(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }
}