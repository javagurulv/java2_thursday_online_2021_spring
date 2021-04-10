package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.services.DeleteEmployeeService;
import java.util.Scanner;

public class DeleteEmployeeUIAction implements UIAction{

    private final DeleteEmployeeService deleteEmployeeService;

    public DeleteEmployeeUIAction(DeleteEmployeeService deleteEmployeeService) {
        this.deleteEmployeeService = deleteEmployeeService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID!");
        Long id = Long.parseLong(scanner.nextLine());
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(id);
        DeleteEmployeeResponse deleteEmployeeResponse = deleteEmployeeService.execute(deleteEmployeeRequest);
        if (deleteEmployeeResponse.isRemoved()) {
            System.out.println("Employee removed!");
        }
        else {
            deleteEmployeeResponse.getErrors().forEach(e -> System.out.println(e.getField() + " " + e.getMessage()));
        }
    }
    @Override
    public String toString() {
        return "Delete Employee";
    }
}