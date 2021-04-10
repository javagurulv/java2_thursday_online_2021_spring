package lv.javaguru.java2.hrsystem.JK.app_JK_no_map;

import lv.javaguru.java2.hrsystem.JK.consoleUI_JK.AddEmployeeUI;
import lv.javaguru.java2.hrsystem.JK.consoleUI_JK.ExitUAction;
import lv.javaguru.java2.hrsystem.JK.consoleUI_JK.GetAllEmployeesUI;
import lv.javaguru.java2.hrsystem.JK.consoleUI_JK.RemoveEmployeeUI;
import lv.javaguru.java2.hrsystem.JK.consoleUI_JK.UIAction;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.JK.services_JK.AddEmployeeService_JK;
import lv.javaguru.java2.hrsystem.JK.services_JK.GetAllEmployees_JK;
import lv.javaguru.java2.hrsystem.JK.services_JK.RemoveEmployeeService_JK;

import java.util.Scanner;

public class EmployeeActionMenu {
    private static Database database = new DatabaseImpl();
    private static final AddEmployeeService_JK addService = new AddEmployeeService_JK(database);
    private static final GetAllEmployees_JK allService = new GetAllEmployees_JK(database);
    private static final RemoveEmployeeService_JK removeService = new RemoveEmployeeService_JK(database);

    private static final UIAction addUIAction = new AddEmployeeUI(addService);
    private static final UIAction allUIAction = new GetAllEmployeesUI(allService);
    private static final UIAction removeUIAction = new RemoveEmployeeUI(removeService);
    private static final UIAction exitUIAction = new ExitUAction();

    private static void printMenu() {
        System.out.println("Program menu:");
        System.out.println("1. Add new employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Show all employees");
        System.out.println("4. Exit");
    }

    private static int getUserOption() throws Exception {
        System.out.println("Enter 1 to 4 menu option to execute:");
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        if (num > 0 && num < 5) {
            return num;
        } else throw new Exception("Invalid number selected");
    }

    private static void performAction(int userOption) {
        switch (userOption) {
            case 1 -> addUIAction.perform();
            case 2 -> removeUIAction.perform();
            case 3 -> allUIAction.perform();
            case 4 -> exitUIAction.perform();
        }
    }

    public static void execute() {
        while (true) {
            printMenu();
            int userOption;
            try {
                userOption = getUserOption();
                performAction(userOption);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}