package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeService;

import java.util.Scanner;

public class AddEmployeeUIAction implements UIAction {

    private AddEmployeeService addEmployeeService;

    public AddEmployeeUIAction(AddEmployeeService addEmployeeService) {
        this.addEmployeeService = addEmployeeService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following employee data");
        System.out.println("Employee name: ");
        String name = scanner.nextLine();
        System.out.println("Employee last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
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

    @Override
    public String toString() {
        return "Add new employee";
    }
}