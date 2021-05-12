package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.config.RealEstateConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private final Map<Integer, ConsoleUI> menuNumberToActionMap;

    private static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(RealEstateConfiguration.class);

    public ConsoleApp() {

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(0, applicationContext.getBean(ExitUIAction.class));
        menuNumberToActionMap.put(1, applicationContext.getBean(CreateUserUIAction.class));
        menuNumberToActionMap.put(2, applicationContext.getBean(LogInUIAction.class));
        menuNumberToActionMap.put(3, applicationContext.getBean(CreateOfferUIAction.class));
        menuNumberToActionMap.put(4, applicationContext.getBean(GetAllOffersUIAction.class));
        menuNumberToActionMap.put(5, applicationContext.getBean(DeleteOfferUIAction.class));
        menuNumberToActionMap.put(6, applicationContext.getBean(DeleteUserUIAction.class));
        menuNumberToActionMap.put(7, applicationContext.getBean(SearchOffersUIAction.class));
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

