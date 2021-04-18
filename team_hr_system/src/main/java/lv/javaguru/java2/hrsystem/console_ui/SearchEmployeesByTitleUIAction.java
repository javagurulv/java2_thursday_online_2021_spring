package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesByTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.SearchEmployeesByTitleService;

import java.util.List;
import java.util.Scanner;

public class SearchEmployeesByTitleUIAction implements UIAction{
    private final SearchEmployeesByTitleService service;

    public SearchEmployeesByTitleUIAction(SearchEmployeesByTitleService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Enter employee title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        SearchEmployeesByTitleRequest request = new SearchEmployeesByTitleRequest(title);
        SearchEmployeesByTitleResponse response = service.execute(request);
        List<Employee> employees = response.getEmployees();
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        }
        else if (!employees.isEmpty()) {
            employees.forEach(System.out::println);
        }
        else {
            System.out.println("No employees with selected title");
        }
    }

    @Override
    public String toString() {
        return "Search employees by selected title";
    }
}