package lv.javaguru.java2.hrsystem.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UIAdminMenu {

    private Map<Integer, UIAction> menuNumberToActionMap;

    @Autowired
    public UIAdminMenu(List<UIAction> uiActions){
        menuNumberToActionMap = new HashMap<>();
        menuNumberToActionMap.put(1, findUIAction(uiActions, AddEmployeeUIAction.class));
        menuNumberToActionMap.put(2, findUIAction(uiActions, AddEmployeeWithTitleUIAction.class));
        menuNumberToActionMap.put(3, findUIAction(uiActions, DeleteEmployeeUIAction.class));
        menuNumberToActionMap.put(4, findUIAction(uiActions, GetAllEmployeesUIAction.class));
        menuNumberToActionMap.put(5, findUIAction(uiActions, SearchEmployeesUIAction.class));
        menuNumberToActionMap.put(6, findUIAction(uiActions, AddSkillUIAction.class));
        menuNumberToActionMap.put(7, findUIAction(uiActions, GetAllEmployeeSkillUIAction.class));
        menuNumberToActionMap.put(8, findUIAction(uiActions, SearchEmployeesBySkillUIAction.class));
        menuNumberToActionMap.put(9, findUIAction(uiActions, ExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void print() {
        System.out.println();
        System.out.println("Admin menu:");
        System.out.println("1. Add Employee");
        System.out.println("2. Add Employee with title");
        System.out.println("3. Delete Employee");
        System.out.println("4. Get all Employees");
        System.out.println("5. Search Employees");
        System.out.println("6. Add skill");
        System.out.println("7. Get all Employee skill");
        System.out.println("8. Search Employees by skill");
        System.out.println("9. Exit");
        System.out.println();
    }

    public int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToActionMap.get(selectedMenu).execute();
    }
}
