package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;

import java.util.List;

public class GetAllTitlesResponse {
    private List<EmployeeTitle> employeeTitles;

    public GetAllTitlesResponse(List<EmployeeTitle> employeeTitles) {
        this.employeeTitles = employeeTitles;
    }

    public List<EmployeeTitle> getEmployeeTitles() {
        return employeeTitles;
    }
}