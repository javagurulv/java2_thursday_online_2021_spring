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

    private final static CreateOfferValidator createOfferValidator = new CreateOfferValidator();
    private final static CreateUserValidator createUserValidator = new CreateUserValidator();
    private final static DeleteUserValidator deleteUserValidator = new DeleteUserValidator();
    private final static LogInValidator logInValidator = new LogInValidator();
    private final static DeleteOfferValidator deleteOfferValidator = new DeleteOfferValidator();
    private final static SearchOffersValidator searchOffersValidator = new SearchOffersValidator();


    private final static CreateUserService createUserService = new CreateUserService(database, createUserValidator);
    private final static CreateOfferService createOfferService = new CreateOfferService(database, createOfferValidator);
    private final static DeleteUserService deleteUserService = new DeleteUserService(database, deleteUserValidator);
    private final static LogInService logInService = new LogInService(database, logInValidator);
    private final static DeleteOfferService deleteOfferService = new DeleteOfferService(database, deleteOfferValidator);
    private final static GetAllOffersService getAllOffersService = new GetAllOffersService(database);
    private final static SearchOffersService searchOffersService = new SearchOffersService(database,searchOffersValidator);

    public ConsoleApp() {

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(0, new ExitUIAction());
        menuNumberToActionMap.put(1, new CreateUserUIAction(createUserService));
        menuNumberToActionMap.put(2, new LogInUIAction(logInService));
        menuNumberToActionMap.put(3, new CreateOfferUIAction(createOfferService));
        menuNumberToActionMap.put(4, new GetAllOffersUIAction(getAllOffersService));
        menuNumberToActionMap.put(5, new DeleteOfferUIAction(deleteOfferService));
        menuNumberToActionMap.put(6, new DeleteUserUIAction(deleteUserService));
        menuNumberToActionMap.put(7, new SearchOffersUIAction(searchOffersService));
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
                "7 = Search offers\n" +
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

