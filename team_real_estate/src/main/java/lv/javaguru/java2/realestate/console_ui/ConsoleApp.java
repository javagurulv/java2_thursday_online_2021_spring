package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.core.services.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private final Map<Integer, ConsoleUI> menuNumberToActionMap;
    private final static Database database = new InMemoryDatabaseImpl();
    private final static CreateUserService createUserService = new CreateUserService(database);
    private final static CreateOfferService createOfferService = new CreateOfferService(database);
    private final static DeleteUserService deleteUserService = new DeleteUserService(database);
    private final static LogInService logInService = new LogInService(database);
    private final static DeleteOfferService deleteOfferService = new DeleteOfferService(database);
    private final static GetAllOffersService getAllOffersService = new GetAllOffersService(database);

    public ConsoleApp() {

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(0, new ExitUIAction());
        menuNumberToActionMap.put(1, new CreateUserUIAction(createUserService));
        menuNumberToActionMap.put(2, new LogInUIAction(logInService));
        menuNumberToActionMap.put(3, new CreateOfferUIAction(createOfferService));
        menuNumberToActionMap.put(4, new GetAllOffersUIAction(getAllOffersService));
        menuNumberToActionMap.put(5, new DeleteOfferUIAction(deleteOfferService));
        menuNumberToActionMap.put(6, new DeleteUserUIAction(deleteUserService));
    }

    public void run() {
        System.out.println("Welcome! \n ");

        while (true) {
            printMenu();
            int userSelectedMenuNumber = getNumberFromUser();
            executeOption(userSelectedMenuNumber);
        }
    }

    private int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private void printMenu() {
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


    private void executeOption(int userMenuChoice) {
        ConsoleUI consoleUI = menuNumberToActionMap.get(userMenuChoice);
        if (consoleUI != null) {
            consoleUI.execute();
        } else {
            System.out.println("Entered number does not exist in menu.");
        }
    }
}

