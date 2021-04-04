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
        System.out.println("Для того чтобы добавить сотрудника введите подные данные!");
        System.out.println("введите Имя: ");
        String firstName = scanner.nextLine();
        System.out.println("введите Фамилию: ");
        String secondName = scanner.nextLine();
        System.out.println("введите Возврост: ");
        int age = scanner.nextInt();

        database.saveEmployee(new Employee(firstName, secondName, age));

        System.out.println("Сотрудник добпвлен!" + "\n" + "|" + database.getAllEmployee().toString() + "|" + "\n");

    }

    @Override
    public String toString() {
        return "Add Employee";
    }
}
