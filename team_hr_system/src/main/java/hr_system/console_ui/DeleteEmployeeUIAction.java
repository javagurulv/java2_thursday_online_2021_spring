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
        System.out.println("Для удаления сотрудника введите ID!");
        System.out.println("введите ID: ");
        database.deleteEmployee(scanner.nextLong());
        System.out.println("Сотрудник удален!");

    }

    @Override
    public String toString() {
        return "Delete Employee";
    }
}
