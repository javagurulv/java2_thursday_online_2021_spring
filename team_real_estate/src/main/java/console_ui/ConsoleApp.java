package console_ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private final Map<Integer, ConsoleUI> menuNumberToActionMap;

    public ConsoleApp() {

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(0, new ExitUIAction());
        menuNumberToActionMap.put(1, new CreateAccountUIAction());
        menuNumberToActionMap.put(2, new LogInUIAction());
        menuNumberToActionMap.put(3, new CreateOfferUIAction());
        menuNumberToActionMap.put(4, new ViewAllOffersUIAction());
    }

    public void run() {
        System.out.println("Welcome! \n ");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Choose available option : \n" + "\n" +
                    "0  = Exit \n" +
                    "1 = Create account \n" +
                    "2 = Log in \n" +
                    "3 = Create offer \n" +
                    "4 = View all offers\n" +
                    "\n");
            System.out.println("Please enter menu number: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Letters not accepted.Please input numbers : ");
            }

            int userSelectedMenuNumber = sc.nextInt();

            if (userSelectedMenuNumber == 0) {
                sc.close();
            }

            executeOption(userSelectedMenuNumber);

        }
    }

    private void executeOption(int userMenuChoice) {
        ConsoleUI consoleUI = menuNumberToActionMap.get(userMenuChoice);
        if (consoleUI != null) {
            consoleUI.execute();
        } else {
            System.out.println("Entered number does not exist in menu.");
        }
    }
}

