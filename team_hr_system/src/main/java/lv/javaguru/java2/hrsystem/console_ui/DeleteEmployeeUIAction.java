package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.services.DeleteEmployeeService;
import java.util.Scanner;

public class DeleteEmployeeUIAction implements UIAction{

    private DeleteEmployeeService deleteEmployeeService;

    public DeleteEmployeeUIAction(DeleteEmployeeService deleteEmployeeService) {

        this.deleteEmployeeService = deleteEmployeeService;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID!");
        System.out.println("enter ID: ");

        deleteEmployeeService.execute(scanner.nextLong());

        System.out.println("Employee removed!");

    }

    @Override
    public String toString() {
        return "Delete Employee";
    }
}
