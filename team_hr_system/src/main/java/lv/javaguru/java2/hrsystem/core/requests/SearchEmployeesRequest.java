package lv.javaguru.java2.hrsystem.core.requests;

public class SearchEmployeesRequest {
    private final String employeeTitle;
    private final String name;

    public SearchEmployeesRequest(String employeeTitle, String name) {
        this.employeeTitle = employeeTitle;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTitleProvided() {
        return employeeTitle != null && !employeeTitle.isEmpty();
    }

    public boolean isNameProvided() {
        return name != null && !name.isEmpty();
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }
}