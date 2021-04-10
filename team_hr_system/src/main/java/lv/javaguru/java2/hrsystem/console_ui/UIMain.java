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

    private Map<Integer, UIAction> menuNumberToActionMap;

    public UIMain() {

        Database database = new DatabaseImpl();

        menuNumberToActionMap = new HashMap<>();
        menuNumberToActionMap.put(1, new AddEmployeeUIAction(new AddEmployeeService(database)));
        menuNumberToActionMap.put(2, new DeleteEmployeeUIAction(new DeleteEmployeeService(database)));
        menuNumberToActionMap.put(3, new GetAllEmployeesUIAction(new GetAllEmployeesService(database)));
        menuNumberToActionMap.put(4, new ExitUIAction());

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select menu option: ");
            for (int i = 1; i < menuNumberToActionMap.size() + 1; i++) {
                System.out.println(i + " - " + menuNumberToActionMap.get(i).toString());
            }
            int userSelectedMenuNumber = Integer.parseInt(scanner.nextLine());
            executeUIAction(userSelectedMenuNumber);
        }
    }

    private void executeUIAction(int userSelectedMenuNumber) {
        UIAction uiAction = menuNumberToActionMap.get(userSelectedMenuNumber);
        if (uiAction != null) {
            uiAction.execute();
        } else {
            System.out.println("No such option: " + userSelectedMenuNumber);
        }
    }
}
