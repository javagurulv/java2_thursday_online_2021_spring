package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeWithTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddEmployeeWithTitleUIAction implements UIAction {

    @Autowired
    private AddEmployeeWithTitleService service;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following employee data");
        System.out.println("Employee name: ");
        String firstName = scanner.nextLine();
        System.out.println("Employee last name: ");
        String secondName = scanner.nextLine();
        int age = getAge();
        System.out.println("Employee title: ");
        String title = scanner.nextLine();
        AddEmployeeWithTitleRequest request = new AddEmployeeWithTitleRequest(firstName, secondName, age, title);
        AddEmployeeWithTitleResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println(coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Employee added successfully!" + "\n" +
                    "id: " + response.getEmployee().getId() + " | name: " + response.getEmployee().getName() + " | last name: " + response.getEmployee().getLastName()
                    + " | age: " + response.getEmployee().getAge() + " | title: " + response.getEmployee().getTitle().getName() + "\n");
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
