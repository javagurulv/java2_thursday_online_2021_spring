package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeWithTitleService;

import java.util.Scanner;

public class AddEmployeeWithTitleUIAction implements UIAction{
    private AddEmployeeWithTitleService service;

    public AddEmployeeWithTitleUIAction(AddEmployeeWithTitleService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following employee data");
        System.out.println("Employee name: ");
        String firstName = scanner.nextLine();
        System.out.println("Employee last name: ");
        String secondName = scanner.nextLine();
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Employee title: ");
        String title = scanner.nextLine();
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest(firstName, secondName, age, title);
        AddEmployeeWithTitleResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(e -> System.out.println(e.getField() + " "+ e.getMessage()));
        }
        else {
            System.out.println("Employee added successfully!" + "\n" +
                    "|" + firstName + " " + secondName + " - " + age + " - " + title + "|" + "\n");
        }
    }
}
