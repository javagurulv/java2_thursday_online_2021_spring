package hr_system.console_ui;

import hr_system.database.Database;
import hr_system.database.DatabaseImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIMain {

    private Map<Integer, UIAction> menuNumberToActionMap;

    public UIMain() {

        Database database = new DatabaseImpl();

        menuNumberToActionMap = new HashMap<>();

        menuNumberToActionMap.put(1, new AddEmployeeUIAction(database));
        menuNumberToActionMap.put(2, new DeleteEmployeeUIAction(database));
        menuNumberToActionMap.put(3, new GetAllEmployeeUIAction(database));

    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Пожалуйста введите пункт меню: ");

            for (int i = 1; i < menuNumberToActionMap.size() + 1; i++) {

                System.out.println(i + " - " + menuNumberToActionMap.get(i).toString());

            }

            int userSelectedMenuNumber = Integer.parseInt(scanner.nextLine());

            if (userSelectedMenuNumber == 0) {

                System.out.println("Досвидания!");

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

            System.out.println("Такого пункта в меню нет: " + userSelectedMenuNumber);

        }
    }
}
