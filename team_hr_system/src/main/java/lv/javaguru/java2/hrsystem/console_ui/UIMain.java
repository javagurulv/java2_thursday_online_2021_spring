package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.AddEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.DeleteEmployeeService;
import lv.javaguru.java2.hrsystem.core.services.GetAllEmployeesService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIMain {

    private final Database database = new DatabaseImpl();

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
           put(1, new AddEmployeeUIAction(new AddEmployeeService(database)));
           put(2, new DeleteEmployeeUIAction(new DeleteEmployeeService(database)));
           put(3, new GetAllEmployeesUIAction(new GetAllEmployeesService(database)));
           put(4, new ExitUIAction());
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
        UIAction uiAction = menuNumberToActionMap.get(userOption);
        if (uiAction != null) {
            uiAction.execute();
        }
    }

    private void printMenu() {
        System.out.println("Program menu:");
        System.out.println("1. Add new employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Show all employees");
        System.out.println("4. Exit");
    }

    public void run() {
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