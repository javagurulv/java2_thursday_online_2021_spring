package hr_system.consoleUI_JK;

import hr_system.services_JK.RemoveEmployeeService_JK;

import java.util.Scanner;

public class RemoveEmployeeUI implements UIAction {
    private RemoveEmployeeService_JK removeEmployeeService_jk;

    public RemoveEmployeeUI(RemoveEmployeeService_JK removeEmployeeService_jk) {
        this.removeEmployeeService_jk = removeEmployeeService_jk;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee id: ");
        Long employeeId = Long.parseLong(scanner.nextLine());
        removeEmployeeService_jk.remove(employeeId);
        System.out.println("Employee removed successfully!");
    }
}