package hr_system.console_ui;

import hr_system.database.Database;
import hr_system.database.DatabaseImpl;
import hr_system.services.AddEmployeeService;
import hr_system.services.DeleteEmployeeService;
import hr_system.services.GetAllEmployeeService;
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
        menuNumberToActionMap.put(3, new GetAllEmployeeUIAction(new GetAllEmployeeService(database)));

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select menu option: ");
            for (int i = 1; i < menuNumberToActionMap.size() + 1; i++) {
                System.out.println(i + " - " + menuNumberToActionMap.get(i).toString());
            }
            int userSelectedMenuNumber = Integer.parseInt(scanner.nextLine());
            if (userSelectedMenuNumber == 0) {
                System.out.println("Good bye!");
                break;
            } else {
                executeUIAction(userSelectedMenuNumber);
            }
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
