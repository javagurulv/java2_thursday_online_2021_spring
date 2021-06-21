package lv.javaguru.java2.hrsystem.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LoginMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public LoginMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, RegisterUserUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, AuthorizeUserUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, ExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    private void printMenu() {
        System.out.println("Select menu option: ");
        menuNumberToUIActionMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private int getUserOption() {
        System.out.printf("Enter 1 to %d menu option to execute:\n", menuNumberToUIActionMap.size());
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean checkUserInput(int input) {
        return input > 0 && input <= menuNumberToUIActionMap.size();
    }

    private void performAction(int userOption) {
        UIAction uiAction = menuNumberToUIActionMap.get(userOption);
        if (uiAction != null) {
            uiAction.execute();
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
