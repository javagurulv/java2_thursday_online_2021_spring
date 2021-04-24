package lv.javaguru.java2.hrsystem.core.requests;

public class SearchEmployeesRequest {
    private final String employeeTitle;
    private final String name;

    private Paging paging;

    public SearchEmployeesRequest(String employeeTitle, String name) {
        this.employeeTitle = employeeTitle;
        this.name = name;
    }

    public SearchEmployeesRequest(String employeeTitle, String name, Paging paging) {
        this.employeeTitle = employeeTitle;
        this.name = name;
        this.paging = paging;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public Paging getPaging() {
        return paging;
    }

    public boolean isTitleProvided() {
        return employeeTitle != null && !employeeTitle.isEmpty();
    }

    public boolean isNameProvided() {
        return name != null && !name.isEmpty();
    }
}