package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.employee.DeleteEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteEmployeeUIAction implements UIAction{

    @Autowired
    private DeleteEmployeeService deleteEmployeeService;

    @Override
    public void execute() {
        Long id = getId();
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(id);
        DeleteEmployeeResponse deleteEmployeeResponse = deleteEmployeeService.execute(deleteEmployeeRequest);
        if (deleteEmployeeResponse.hasErrors()) {
            deleteEmployeeResponse.getErrors().forEach(e -> System.out.println(e.getField() + " " + e.getMessage()));
        }
        else if (deleteEmployeeResponse.isRemoved()) {
            System.out.println("Employee removed!");
        }
        else {
            System.out.println("Employee is not removed!");
        }
    }

    private Long getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID!");
        boolean valid = false;
        Long id = null;
        while (!valid) {
            try {
                id = Long.parseLong(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric value!");
                valid = false;
            }
        }
        return id;
    }

    @Override
    public String toString() {
        return "Remove employee";
    }
}