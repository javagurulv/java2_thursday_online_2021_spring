package lv.javaguru.java2.hrsystem.core.requests;

public class SearchEmployeesRequest {
    private final String employeeTitle;
    private final String name;

    private Ordering ordering;

    private Paging paging;

    public SearchEmployeesRequest(String employeeTitle, String name) {
        this.employeeTitle = employeeTitle;
        this.name = name;
    }

    public SearchEmployeesRequest(String employeeTitle, String name, Ordering ordering) {
        this.employeeTitle = employeeTitle;
        this.name = name;
        this.ordering = ordering;
    }

    public SearchEmployeesRequest(String employeeTitle, String name, Paging paging) {
        this.employeeTitle = employeeTitle;
        this.name = name;
        this.paging = paging;
    }

    public SearchEmployeesRequest(String employeeTitle, String name, Ordering ordering, Paging paging) {
        this.employeeTitle = employeeTitle;
        this.name = name;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public Ordering getOrdering() {
        return ordering;
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