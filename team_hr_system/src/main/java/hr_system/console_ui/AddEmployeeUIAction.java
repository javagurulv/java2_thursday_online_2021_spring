package hr_system.console_ui;

import hr_system.bean.Employee;
import hr_system.database.Database;
import java.util.Scanner;

public class AddEmployeeUIAction implements UIAction{

    private Database database;

    public AddEmployeeUIAction(Database database) {

        this.database = database;

    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the following employee data");
        System.out.println("Employee name: ");
        String firstName = scanner.nextLine();
        System.out.println("Employee last name: ");
        String secondName = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();

        database.saveEmployee(new Employee(firstName, secondName, age));

        System.out.println("Employee added successfully!" + "\n" + "|" + database.getAllEmployees().toString() + "|" + "\n");

    }

    @Override
    public String toString() {
        return "Add Employee";
    }
}
