package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.*;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.AddSkillRequestValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesBySkillRequestValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesRequestValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIMain {

    private final Database database = new DatabaseImpl();
    private static AddEmployeeValidator addEmployeeValidator = new AddEmployeeValidator();
    private static SearchEmployeesRequestValidator searchEmployeesRequestValidator = new SearchEmployeesRequestValidator();
    private static AddSkillRequestValidator addSkillRequestValidator = new AddSkillRequestValidator();
    private static SearchEmployeesBySkillRequestValidator searchEmployeesBySkillRequestValidator = new SearchEmployeesBySkillRequestValidator();

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
        put(1, new AddEmployeeUIAction(new AddEmployeeService(database, addEmployeeValidator)));
        put(2, new AddEmployeeWithTitleUIAction(new AddEmployeeWithTitleService(database)));
        put(3, new DeleteEmployeeUIAction(new DeleteEmployeeService(database)));
        put(4, new GetAllEmployeesUIAction(new GetAllEmployeesService(database)));
        put(5, new SearchEmployeesUIAction(new SearchEmployeesService(database, searchEmployeesRequestValidator)));
        put(6, new AddSkillUIAction(new AddSkillService(database, addSkillRequestValidator)));
        put(7, new GetAllEmployeeSkillUIAction(new GetAllEmployeeSkillsService(database)));
        put(8, new SearchEmployeesBySkillUIAction(new SearchEmployeesBySkillService(database,searchEmployeesBySkillRequestValidator)));
        put(9, new ExitUIAction());
    }};

    private int getUserOption() {
        System.out.printf("Enter 1 to %d menu option to execute:\n", menuNumberToActionMap.size());
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
        menuNumberToActionMap.forEach((key, value) -> System.out.println(key + " - " + value));
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