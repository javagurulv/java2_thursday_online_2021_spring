package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.bean.Employee;
import lv.javaguru.java2.hrsystem.bean.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.GetEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetEmployeesByTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.GetEmployeesByTitleService;

import java.util.List;
import java.util.Scanner;

public class GetAllEmployeesByTitleUIAction implements UIAction{
    private final GetEmployeesByTitleService service;

    public GetAllEmployeesByTitleUIAction(GetEmployeesByTitleService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Enter employee title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        GetEmployeesByTitleRequest request = new GetEmployeesByTitleRequest(EmployeeTitle.valueOf(title));
        GetEmployeesByTitleResponse response = service.execute(request);
        List<Employee> employees = response.getEmployees();
        if (!employees.isEmpty()) {
            employees.forEach(System.out::println);
        }
        else {
            System.out.println("No employees with selected title");
        }
    }
}