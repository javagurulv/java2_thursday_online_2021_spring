package lv.javaguru.java2.hrsystem.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UIProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public UIProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, RegisterUserUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, AuthorizeUserUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, GetAllUsersUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, ExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void print() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Registration");
        System.out.println("2. Authorization");
        System.out.println("3. Show all users");
        System.out.println("4. Exit");
        System.out.println();
    }

    public int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToUIActionMap.get(selectedMenu).execute();
    }
}
