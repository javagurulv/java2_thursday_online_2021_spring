package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIMain {

    private final Database database = new DatabaseImpl();
    private static AddEmployeeValidator addEmployeeValidator = new AddEmployeeValidator();

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
        put(1, new AddEmployeeUIAction(new AddEmployeeService(database, addEmployeeValidator)));
        put(2, new AddEmployeeWithTitleUIAction(new AddEmployeeWithTitleService(database)));
        put(3, new DeleteEmployeeUIAction(new DeleteEmployeeService(database)));
        put(4, new GetAllEmployeesUIAction(new GetAllEmployeesService(database)));
        put(5, new GetAllEmployeesByTitleUIAction(new GetEmployeesByTitleService(database)));
        put(6, new ExitUIAction());

    }};

    private int getUserOption() {
        System.out.println("Enter 1 to 6 menu option to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean checkUserInput(int input) {
        return input > 0 && input <= menuNumberToActionMap.size();
    }

    private void performAction(int userOption) {
        UIAction uiAction = menuNumberToActionMap.get(userOption);
        if (uiAction != null) {
            uiAction.execute();
        }
    }

    private void printMenu() {
        System.out.println("Select menu option: ");
        for (int i = 1; i < menuNumberToActionMap.size() + 1; i++) {
            System.out.println(i + " - " + menuNumberToActionMap.get(i).toString());
        }
    }

    public void run() {
        while (true) {
            printMenu();
            int option = getUserOption();
            if (checkUserInput(option)) {
                performAction(option);
            } else {
                System.out.println("Invalid menu option entered! Please try again");
            }
        }
    }
}