package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.services.AddEmployeeService;
import java.util.Scanner;

public class AddEmployeeUIAction implements UIAction{

    private AddEmployeeService addEmployeeService;

    public AddEmployeeUIAction(AddEmployeeService addEmployeeService) {

        this.addEmployeeService = addEmployeeService;

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

        addEmployeeService.execute(firstName, secondName, age);

        System.out.println("Employee added successfully!" + "\n" +
                "|" + firstName + " " + secondName +  " - " + age + "|" + "\n");

    }

    @Override
    public String toString() {
        return "Add Employee";
    }
}
