package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeService;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class AddEmployeeUIAction implements UIAction {

    @DIDependency private AddEmployeeService addEmployeeService;

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
                    response.getNewEmployee() + "\n");
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
