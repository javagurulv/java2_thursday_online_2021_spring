package hr_system.console_ui;

import hr_system.database.Database;
import java.util.Scanner;

public class DeleteEmployeeUIAction implements UIAction{

    private Database database;

    public DeleteEmployeeUIAction(Database database) {

        this.database = database;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID!");
        System.out.println("enter ID: ");
        database.deleteEmployee(scanner.nextLong());
        System.out.println("Employee removed!");

    }

    @Override
    public String toString() {
        return "Delete Employee";
    }
}
