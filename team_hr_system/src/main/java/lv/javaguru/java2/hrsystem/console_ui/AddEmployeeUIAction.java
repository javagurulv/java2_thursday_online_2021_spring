package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.AddEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddEmployeeUIAction implements UIAction {

    @Autowired
    private AddEmployeeService addEmployeeService;

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following employee data");
        System.out.println("Employee name: ");
        String name = scanner.nextLine();
        System.out.println("Employee last name: ");
        String lastName = scanner.nextLine();
        int age = getAge();
        AddEmployeeRequest request = new AddEmployeeRequest(name, lastName, age);
        AddEmployeeResponse response = addEmployeeService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Employee added successfully!" + "\n" +
                    "id: " + response.getNewEmployee().getId() + " | name: " + response.getNewEmployee().getName() + " | last name: " + response.getNewEmployee().getLastName()
                    + " | age: " + response.getNewEmployee().getAge() + "\n");
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
        return "Add new employee";
    }
}
