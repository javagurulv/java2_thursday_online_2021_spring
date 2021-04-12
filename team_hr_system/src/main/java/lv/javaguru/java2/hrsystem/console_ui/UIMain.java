package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIMain {

    private final Database database = new DatabaseImpl();

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
        put(1, new AddEmployeeUIAction(new AddEmployeeService(database)));
        put(2, new AddEmployeeWithTitleUIAction(new AddEmployeeWithTitleService(database)));
        put(3, new DeleteEmployeeUIAction(new DeleteEmployeeService(database)));
        put(4, new GetAllEmployeesUIAction(new GetAllEmployeesService(database)));
        put(5, new GetAllEmployeesByTitleUIAction(new GetEmployeesByTitle(database)));
        put(6, new ExitUIAction());

    }};

    private int getUserOption() {
        System.out.println("Enter 1 to 6 menu option to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean checkUserInput(int input) {
        return input > 0 && input < 7;
    }

    private void performAction(int userOption) {
        UIAction uiAction = menuNumberToActionMap.get(userOption);
        if (uiAction != null) {
            uiAction.execute();
        }
    }

    private void printMenu() {
        System.out.println("Program menu:");
        System.out.println("1. Add new employee");
        System.out.println("2. Add new employee with title");
        System.out.println("3. Remove employee");
        System.out.println("4. Show all employees");
        System.out.println("5. Show all employees by selected title");
        System.out.println("6. Exit");
    }

    public void run() {
        while (true) {
            printMenu();
            int option = getUserOption();
            if (checkUserInput(option)) {
                performAction(option);
            } else {
                System.out.println("Invalid number entered! Please try again");
            }
        }
    }
}