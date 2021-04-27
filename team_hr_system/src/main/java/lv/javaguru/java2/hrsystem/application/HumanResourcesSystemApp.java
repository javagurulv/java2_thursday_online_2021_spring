package lv.javaguru.java2.hrsystem.application;

import lv.javaguru.java2.hrsystem.console_ui.*;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.core.services.AuthorizationService;
import lv.javaguru.java2.hrsystem.core.services.GetAllUsersService;
import lv.javaguru.java2.hrsystem.core.services.RegistrationService;
import lv.javaguru.java2.hrsystem.core.services.validators.AuthorizationValidator;
import lv.javaguru.java2.hrsystem.core.services.validators.RegistrationValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HumanResourcesSystemApp {

    private final Database database = new DatabaseImpl();

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
        put(1, new RegistrationUIAction(new RegistrationService(database, new RegistrationValidator())));
        put(2, new AuthorizationUIAction(new AuthorizationService(database, new AuthorizationValidator())));
        put(3, new GetAllUsersUIAction(new GetAllUsersService(database)));
        put(4, new ExitUIAction());
    }};

        public static void main(String[] args) {

            HumanResourcesSystemApp humanResourcesSystemApp = new HumanResourcesSystemApp();
            humanResourcesSystemApp.run();

    }

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