package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeWithTitleService;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class AddEmployeeWithTitleUIAction implements UIAction{

    @DIDependency private AddEmployeeWithTitleService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following employee data");
        System.out.println("Employee name: ");
        String firstName = scanner.nextLine();
        System.out.println("Employee last name: ");
        String secondName = scanner.nextLine();
        int age = getAge();
        System.out.println("Employee title from the following: \n" +
                "    DEVELOPER,\n" +
                "    QA_ENGINEER,\n" +
                "    BA,\n" +
                "    MANAGER,\n" +
                "    HR_MANAGER,\n" +
                "    SALES_MANAGER");
        String title = scanner.nextLine();
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest(firstName, secondName, age, title.toUpperCase());
        AddEmployeeWithTitleResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Employee added successfully!" + "\n" +
                    "|" + response.getEmployee().getName() + " " + response.getEmployee().getLastName()
                    + " - " + response.getEmployee().getAge() + " - " + response.getEmployee().getTitle() + "|" + "\n");
        }
    }

    private int getAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Age: ");
        boolean valid = false;
        int age = 0;
        while (!valid) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric value!");
                valid = false;
            }
        }
        return age;
    }

    @Override
    public String toString() {
        return "Add new employee with title";
    }
}
