package lv.javaguru.java2.hrsystem.console_ui;

import lv.javaguru.java2.hrsystem.dependency_injection.ApplicationContext;
import lv.javaguru.java2.hrsystem.dependency_injection.DIApplicationContextBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIMain {

    private static ApplicationContext applicationContext = new DIApplicationContextBuilder()
            .build("lv.javaguru.java2.hrsystem");

    private final Map<Integer, UIAction> menuNumberToActionMap = new HashMap<>() {{
        put(1, applicationContext.getBean(AddEmployeeUIAction.class));
        put(2, applicationContext.getBean(AddEmployeeWithTitleUIAction.class));
        put(3, applicationContext.getBean(DeleteEmployeeUIAction.class));
        put(4, applicationContext.getBean(GetAllEmployeesUIAction.class));
        put(5, applicationContext.getBean(SearchEmployeesUIAction.class));
        put(6, applicationContext.getBean(AddSkillUIAction.class));
        put(7, applicationContext.getBean(GetAllEmployeeSkillUIAction.class));
        put(8, applicationContext.getBean(SearchEmployeesBySkillUIAction.class));
        put(9, applicationContext.getBean(ExitUIAction.class));
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