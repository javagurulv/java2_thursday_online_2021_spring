package lv.javaguru.java2.hrsystem.application;

import lv.javaguru.java2.hrsystem.config.HumanResourcesSystemConfiguration;
import lv.javaguru.java2.hrsystem.console_ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class HumanResourcesSystemApp {

    private static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(HumanResourcesSystemConfiguration.class);

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
        put(1, applicationContext.getBean(RegisterUserUIAction.class));
        put(2, applicationContext.getBean(AuthorizeUserUIAction.class));
        put(3, applicationContext.getBean(GetAllUsersUIAction.class));
        put(4, applicationContext.getBean(ExitUIAction.class));
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