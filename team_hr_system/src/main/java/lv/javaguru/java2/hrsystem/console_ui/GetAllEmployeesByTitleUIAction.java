package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.bean.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.GetEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetEmployeesByTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.GetEmployeesByTitle;

import java.util.Scanner;

public class GetAllEmployeesByTitleUIAction implements UIAction{
    private final GetEmployeesByTitle service;

    public GetAllEmployeesByTitleUIAction(GetEmployeesByTitle service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Enter employee title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        GetEmployeesByTitleRequest request = new GetEmployeesByTitleRequest(EmployeeTitle.valueOf(title));
        GetEmployeesByTitleResponse response = service.execute(request);
        response.getEmployees().forEach(System.out::println);
    }
}