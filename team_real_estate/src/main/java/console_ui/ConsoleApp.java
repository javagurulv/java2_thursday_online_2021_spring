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
        menuNumberToActionMap.put(5, new DeleteOfferUIAction());
        menuNumberToActionMap.put(6, new DeleteAccountUIAction());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int userSelectedMenuNumber;
        while (true) {
            printMenu();
            checkIfUserEnteredNumber(scanner);

            userSelectedMenuNumber = scanner.nextInt();

            if (userSelectedMenuNumber == 0) {
                scanner.close();
            }
            executeOption(userSelectedMenuNumber);

        }
    }

    private void printMenu() {
        System.out.println("Welcome! \n ");
        System.out.print("Choose available option : \n" + "\n" +
                "0  = Exit \n" +
                "1 = Create account \n" +
                "2 = Log in \n" +
                "3 = Create offer \n" +
                "4 = View all offers\n" +
                "5 = Delete offer\n" +
                "6 = Delete account\n" +
                "\n");
        System.out.println("Please enter menu number: ");
    }

    private void checkIfUserEnteredNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Letters not accepted.Please input numbers : ");
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

