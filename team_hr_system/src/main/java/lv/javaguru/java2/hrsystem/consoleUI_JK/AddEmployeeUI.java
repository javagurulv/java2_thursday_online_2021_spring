package lv.javaguru.java2.hrsystem.consoleUI_JK;

import lv.javaguru.java2.hrsystem.services_JK.AddEmployeeService_JK;

import java.util.Scanner;

public class AddEmployeeUI implements UIAction{

    private AddEmployeeService_JK addEmployeeService_jk;

    public AddEmployeeUI(AddEmployeeService_JK addEmployeeService_jk) {
        this.addEmployeeService_jk = addEmployeeService_jk;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter employee last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter employee age: ");
        int age = Integer.parseInt(scanner.nextLine());
        addEmployeeService_jk.add(firstName, lastName, age);
        System.out.println("New employee added successfully!");
    }
}