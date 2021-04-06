package hr_system.app_JK_with_map;

import hr_system.consoleUI_JK.*;
import hr_system.database.Database;
import hr_system.database.DatabaseImpl;
import hr_system.services_JK.AddEmployeeService_JK;
import hr_system.services_JK.GetAllEmployees_JK;
import hr_system.services_JK.RemoveEmployeeService_JK;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeActionMenu {

    private final Database database = new DatabaseImpl();

    private final Map<Integer, UIAction> uiActionMap = new HashMap<>() {{
        put(1, new AddEmployeeUI(new AddEmployeeService_JK(database)));
        put(2, new RemoveEmployeeUI(new RemoveEmployeeService_JK(database)));
        put(3, new GetAllEmployeesUI(new GetAllEmployees_JK(database)));
        put(4, new ExitUAction());
    }};

    private int getUserOption() throws Exception {
        System.out.println("Enter 1 to 4 menu option to execute:");
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        if (num > 0 && num < 5) {
            return num;
        } else throw new Exception("Invalid number selected");
    }

    private void performAction(int userOption) {
        uiActionMap.get(userOption).perform();
    }

    private void printMenu() {
        System.out.println("Program menu:");
        System.out.println("1. Add new employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Show all employees");
        System.out.println("4. Exit");
    }

    public void executeMenu() {
        while (true) {
            printMenu();
            int option;
            try {
                option = getUserOption();
                performAction(option);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}