package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.Ordering;
import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.SearchEmployeesService;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class SearchEmployeesUIAction implements UIAction {

    @Autowired
    private SearchEmployeesService service;


    @Override
    public void execute() {
        System.out.println("Enter employee title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("Enter orderBy (title||name): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter page number: ");
        Integer pageNumber = scanner.nextInt();
        System.out.println("Enter size name: ");
        Integer pageSize = scanner.nextInt();

        Paging paging = new Paging(pageNumber, pageSize);

        SearchEmployeesRequest request = new SearchEmployeesRequest(title, name, ordering, paging);
        SearchEmployeesResponse response = service.execute(request);

        List<Employee> employees = response.getEmployees();

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else if (!employees.isEmpty()) {
            employees.forEach(System.out::println);
        } else {
            System.out.println("No employees found");
        }
    }

    @Override
    public String toString() {
        return "Search employees";
    }
}